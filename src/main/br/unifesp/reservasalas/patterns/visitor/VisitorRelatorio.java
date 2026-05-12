package main.br.unifesp.reservasalas.patterns.visitor;

import main.br.unifesp.reservasalas.domain.Reserva;

public interface VisitorRelatorio {
    void visitar(Reserva reserva);
}