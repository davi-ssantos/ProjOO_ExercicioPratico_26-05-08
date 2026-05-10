package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.StatusReserva;
import main.br.unifesp.reservasalas.enums.TipoEvento;
import main.br.unifesp.reservasalas.patterns.observer.Observador;
import main.br.unifesp.reservasalas.patterns.observer.Evento;
import main.br.unifesp.reservasalas.patterns.visitor.VisitorRelatorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private String              id;
    private Usuario             usuario;
    private Sala                sala;
    private LocalDateTime       inicio;
    private LocalDateTime       fim;
    private StatusReserva       status;
    private List<Observador>    observadores;

    public Reserva(String id, Usuario usuario, Sala sala,
                   LocalDateTime inicio, LocalDateTime fim,
                   List<Observador> observadores) {

        this.id             = id;
        this.usuario        = usuario;
        this.sala           = sala;
        this.inicio         = inicio;
        this.fim            = fim;
        this.status         = StatusReserva.CONFIRMADA;
        this.observadores   = new ArrayList<>(observadores);
    }

    public String getId()               { return id; }
    public Usuario getUsuario()         { return usuario; }
    public Sala getSala()               { return sala; }
    public LocalDateTime getInicio()    { return inicio; }
    public LocalDateTime getFim()       { return fim; }
    public StatusReserva getStatus()    { return status; }

    public void confirmar() {
        this.status = StatusReserva.CONFIRMADA;
        notificarObservadores(TipoEvento.CRIACAO);
    }

    public void cancelar() {
        this.status = StatusReserva.CANCELADA;
        notificarObservadores(TipoEvento.CANCELAMENTO);
    }

    public void modificar(LocalDateTime novoInicio, LocalDateTime novoFim) {
        this.inicio = novoInicio;
        this.fim = novoFim;
        this.status = StatusReserva.MODIFICADA;
        notificarObservadores(TipoEvento.MODIFICACAO);
    }

    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void removerObservador(Observador obs) {
        observadores.remove(obs);
    }

    private void notificarObservadores(TipoEvento tipoEvento) {
        Evento evento = new Evento(tipoEvento, this);
        for (Observador obs : observadores) {
            obs.notificar(evento);
        }
    }

    public void aceitar(VisitorRelatorio visitor) {
        visitor.visitar(this);
    }
}