package model;

import java.util.UUID;

public abstract class  Pessoa  {

    private String id = UUID.randomUUID().toString();
    private String nome;
    private String email;
    private String senha;
    public Pessoa (){

    }

    public Pessoa(String id, String nome,String email, String senha) {
        this.senha=senha;
        this.email=email;
        this.nome=nome;
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}