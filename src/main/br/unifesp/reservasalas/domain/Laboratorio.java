package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoSala;

public class Laboratorio extends Sala {

    private int numComputadores;

    public Laboratorio(String id, String nome, int capacidade, int numComputadores) {
        super(id, nome, capacidade);
        this.numComputadores = numComputadores;
    }

    public int getNumComputadores() { return numComputadores; }

    @Override
    public String getDescricao() {
        return "Laboratório, capacidade: " + getCapacidade() +
                ", computadores: " + numComputadores;
    }

    @Override
    public TipoSala getTipo() { return TipoSala.LABORATORIO; }
}
