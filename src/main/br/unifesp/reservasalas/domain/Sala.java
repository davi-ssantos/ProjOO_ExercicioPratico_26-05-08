package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoSala;

public abstract class Sala {

    private String  id;
    private String  nome;
    private int     capacidade;
    private boolean disponivel;

    protected Sala(String id, String nome, int capacidade) {
        this.id         = id;
        this.nome       = nome;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public String getId()           { return id; }
    public String getNome()         { return nome; }
    public int getCapacidade()      { return capacidade; }
    public boolean isDisponivel()   { return disponivel; }

    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public abstract String getDescricao();
    public abstract TipoSala getTipo();
}

