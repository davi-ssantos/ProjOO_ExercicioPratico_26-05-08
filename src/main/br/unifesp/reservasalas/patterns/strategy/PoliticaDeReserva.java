package main.br.unifesp.reservasalas.patterns.strategy;

import main.br.unifesp.reservasalas.domain.Reserva;

import java.util.List;

public interface PoliticaDeReserva {
    boolean validar(Reserva reservaNova, List<Reserva> reservasExistentes);
}