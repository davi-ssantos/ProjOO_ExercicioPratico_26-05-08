package main.br.unifesp.reservasalas.patterns.decorator;

import main.br.unifesp.reservasalas.domain.Reserva;

public abstract class ReservaDecorator {

    private Reserva reservaDecorada;

    protected ReservaDecorator(Reserva reservaDecorada) {
        this.reservaDecorada = reservaDecorada;
    }

    public Reserva getReservaDecorada() { return reservaDecorada; }

    public abstract String getDescricaoExtras();
    public abstract double getCustoExtra();
}