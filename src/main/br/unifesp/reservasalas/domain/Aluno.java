package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoUsuario;

public class Aluno extends Usuario {

    private String matricula;

    public Aluno(String id, String nome, String email, String senha, String matricula) {
        super(id, nome, email, senha);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }

    @Override
    public int getPrioridade() { return 1; }

    @Override
    public TipoUsuario getTipo() { return TipoUsuario.ALUNO; }
}