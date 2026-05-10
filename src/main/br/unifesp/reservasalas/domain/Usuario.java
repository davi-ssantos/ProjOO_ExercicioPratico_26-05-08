package main.br.unifesp.reservasalas.domain;

import main.br.unifesp.reservasalas.enums.TipoUsuario;

public abstract class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;

    protected Usuario(String id, String nome, String email, String senha) {
        this.id     = id;
        this.nome   = nome;
        this.email  = email;
        this.senha  = senha;
    }

    public String getId()       { return id; }
    public String getNome()     { return nome; }
    public String getEmail()    { return email; }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public abstract int getPrioridade();
    public abstract TipoUsuario getTipo();
}