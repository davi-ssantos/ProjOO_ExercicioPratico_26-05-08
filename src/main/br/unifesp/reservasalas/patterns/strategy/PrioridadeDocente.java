package main.br.unifesp.reservasalas.patterns.strategy;

import main.br.unifesp.reservasalas.domain.Reserva;

import java.util.List;

public class PrioridadeDocente implements PoliticaDeReserva {

    @Override
    public boolean validar(Reserva reservaNova, List<Reserva> reservasExistentes) {
        for (Reserva reserva : reservasExistentes) {
            if (reserva.getSala().getId().equals(reservaNova.getSala().getId()) &&
                    reserva.getInicio().isBefore(reservaNova.getFim()) &&
                    reserva.getFim().isAfter(reservaNova.getInicio())) {
                if (reservaNova.getUsuario().getPrioridade() <=
                        reserva.getUsuario().getPrioridade()) {
                    return false;
                }
            }
        }
        return true;
    }
}