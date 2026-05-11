package main.br.unifesp.reservasalas.patterns.decorator;

import main.br.unifesp.reservasalas.domain.Reserva;

public class ReservaComQuadroNegro extends ReservaDecorator {

    public ReservaComQuadroNegro(Reserva reservaDecorada) {
        super(reservaDecorada);
    }

    @Override
    public String getDescricaoExtras() { return "Quadro negro"; }

    @Override
    public double getCustoExtra() { return 10.0; }
}