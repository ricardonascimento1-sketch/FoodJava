package model;

public abstract class  Pessoa  {

    private String nome;
    private String email;
    private String senha;
    public Pessoa (){

    }

    public Pessoa(String nome,String email, String senha) {
        this.senha=senha;
        this.email=email;
        this.nome=nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}