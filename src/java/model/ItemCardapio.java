package model;

public class ItemCardapio {
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private boolean disponivel;

    public ItemCardapio(){

    }

    public ItemCardapio(String nome, String descricao, double preco, String categoria, boolean disponivel) {
        this.nome = nome;
        this.descricao=descricao;
        this.preco=preco;
        this.categoria=categoria;
        this.disponivel=disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
