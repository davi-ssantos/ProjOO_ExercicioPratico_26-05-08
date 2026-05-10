package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoUsuario;

public class Docente extends Usuario {

    private String departamento;

    public Docente(String id, String nome, String email, String senha, String departamento) {
        super(id, nome, email, senha);
        this.departamento = departamento;
    }

    public String getDepartamento() { return departamento; }

    @Override
    public int getPrioridade() { return 2; }

    @Override
    public TipoUsuario getTipo() { return TipoUsuario.DOCENTE; }
}
