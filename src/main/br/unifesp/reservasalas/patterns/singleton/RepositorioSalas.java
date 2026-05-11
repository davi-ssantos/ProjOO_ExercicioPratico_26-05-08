package main.br.unifesp.reservasalas.patterns.singleton;

import main.br.unifesp.reservasalas.domain.Reserva;
import main.br.unifesp.reservasalas.domain.Sala;
import main.br.unifesp.reservasalas.domain.Usuario;
import main.br.unifesp.reservasalas.patterns.proxy.SalaProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioSalas {

    private static RepositorioSalas     instancia;
    private Map<String, Sala>           salas;
    private Map<String, Reserva>        reservas;
    private Map<String, Usuario>        usuarios;
    private SalaProxy                   proxy;

    private RepositorioSalas() {
        this.salas      = new HashMap<>();
        this.reservas   = new HashMap<>();
        this.usuarios   = new HashMap<>();
        this.proxy      = new SalaProxy("salas.txt");
    }

    public static synchronized RepositorioSalas getInstance() {
        if (instancia == null) {
            instancia = new RepositorioSalas();
        }
        return instancia;
    }

    // Salas
    public void adicionarSala(Sala sala) {
        salas.put(sala.getId(), sala);
    }

    public Sala buscarSalaPorId(String id) {
        if (salas.containsKey(id)) {
            return salas.get(id);
        }
        return proxy.buscarSala(id);
    }

    public List<Sala> listarSalas() {
        return new ArrayList<>(salas.values());
    }

    public List<Sala> listarSalasDisponiveis() {
        List<Sala> disponiveis = new ArrayList<>();
        for (Sala sala : salas.values()) {
            if (sala.isDisponivel()) {
                disponiveis.add(sala);
            }
        }
        return disponiveis;
    }

    // Reservas
    public void adicionarReserva(Reserva reserva) {
        reservas.put(reserva.getId(), reserva);
    }

    public Reserva buscarReservaPorId(String id) {
        return reservas.get(id);
    }

    public List<Reserva> listarReservasPorSala(String salaId) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas.values()) {
            if (reserva.getSala().getId().equals(salaId)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<Reserva> listarReservasPorUsuario(String usuarioId) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas.values()) {
            if (reserva.getUsuario().getId().equals(usuarioId)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<Reserva> listarReservasPorData(LocalDate data) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas.values()) {
            if (reserva.getInicio().toLocalDate().equals(data)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public void removerReserva(String id) {
        reservas.remove(id);
    }

    // Usuarios
    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public Usuario buscarUsuarioPorId(String id) {
        return usuarios.get(id);
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }
}