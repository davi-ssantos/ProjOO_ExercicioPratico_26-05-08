package main.br.unifesp.reservasalas.patterns.observer;

import main.br.unifesp.reservasalas.domain.Usuario;

public class UsuarioObservador implements Observador {

    private Usuario usuario;

    public UsuarioObservador(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() { return usuario; }

    @Override
    public void notificar(Evento evento) {
        System.out.println("Notificação para " + usuario.getNome() +
                ": reserva da sala " + evento.getReserva().getSala().getNome() +
                " foi " + evento.getTipo().toString().toLowerCase() +
                " em " + evento.getTimestamp());
    }
}