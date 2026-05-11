package main.br.unifesp.reservasalas.patterns.decorator;

import main.br.unifesp.reservasalas.domain.Reserva;

public class ReservaComMultimidia extends ReservaDecorator {

    public ReservaComMultimidia(Reserva reservaDecorada) {
        super(reservaDecorada);
    }

    @Override
    public String getDescricaoExtras() { return "Equipamento multimídia"; }

    @Override
    public double getCustoExtra() { return 50.0; }
}