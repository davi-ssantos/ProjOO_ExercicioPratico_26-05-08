package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoSala;

public class SalaEstudoIndividual extends Sala {

    public SalaEstudoIndividual(String id, String nome, int capacidade) {
        super(id, nome, capacidade);
    }

    @Override
    public String getDescricao() {
        return "Sala de estudo individual, silenciosa, capacidade: " + getCapacidade();
    }

    @Override
    public TipoSala getTipo() { return TipoSala.INDIVIDUAL; }
}