package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoSala;

public class SalaTrabalhoGrupo extends Sala {

    private boolean temQuadroNegro;

    public SalaTrabalhoGrupo(String id, String nome, int capacidade, boolean temQuadroNegro) {
        super(id, nome, capacidade);
        this.temQuadroNegro = temQuadroNegro;
    }

    public boolean temQuadroNegro() { return temQuadroNegro; }

    @Override
    public String getDescricao() {
        return "Sala de trabalho em grupo, capacidade: " + getCapacidade() +
                ", quadro negro: " + (temQuadroNegro ? "sim" : "não");
    }

    @Override
    public TipoSala getTipo() { return TipoSala.GRUPO; }
}
