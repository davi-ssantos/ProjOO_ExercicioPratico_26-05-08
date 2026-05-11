package main.br.unifesp.reservasalas.patterns.observer;

import main.br.unifesp.reservasalas.domain.Reserva;
import main.br.unifesp.reservasalas.enums.TipoEvento;

import java.time.LocalDateTime;

public class Evento {

    private TipoEvento      tipo;
    private Reserva         reserva;
    private LocalDateTime   timestamp;

    public Evento(TipoEvento tipo, Reserva reserva) {
        this.tipo       = tipo;
        this.reserva    = reserva;
        this.timestamp  = LocalDateTime.now();
    }

    public TipoEvento getTipo()         { return tipo; }
    public Reserva getReserva()         { return reserva; }
    public LocalDateTime getTimestamp() { return timestamp; }
}