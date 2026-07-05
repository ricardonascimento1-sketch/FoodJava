package model;

public class ItemPedido {
    private String itemId;
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public ItemPedido(){

    }
    public ItemPedido(ItemCardapio item, int quantidade) {
        this.itemId = itemId;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return precoUnitario * quantidade;
    }

    public void incrementar() {
        quantidade++;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "itemId='" + itemId + '\'' +
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                '}';
    }
}
