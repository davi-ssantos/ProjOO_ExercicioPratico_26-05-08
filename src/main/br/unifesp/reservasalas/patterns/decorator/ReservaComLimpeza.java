package main.br.unifesp.reservasalas.patterns.decorator;

import main.br.unifesp.reservasalas.domain.Reserva;

public class ReservaComLimpeza extends ReservaDecorator {

    public ReservaComLimpeza(Reserva reservaDecorada) {
        super(reservaDecorada);
    }

    @Override
    public String getDescricaoExtras() { return "Serviço de limpeza"; }

    @Override
    public double getCustoExtra() { return 70.0; }
}