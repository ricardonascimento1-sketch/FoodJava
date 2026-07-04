package model;
import exception.StatusInvalidoException;

public class StatusPedido {
    private final String nome;


    public StatusPedido(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static final StatusPedido Aguardando_Pedido = new StatusPedido("Aguardando Pedido");

    public static final StatusPedido Em_Preparacao = new StatusPedido("Em Preparação");

    public static final StatusPedido Pronto = new StatusPedido("Pronto");

    public static final StatusPedido Entregue = new StatusPedido("Entregue");

    public static final StatusPedido Cancelado = new StatusPedido("Cancelado");

    public StatusPedido proximo() throws StatusInvalidoException {
        if (this == Aguardando_Pedido) {
            return Em_Preparacao;
        } else if (this == Em_Preparacao) {
            return Pronto;
        } else if (this == Pronto) {
            return Entregue;
        } else if (this == Entregue) {
            throw new StatusInvalidoException("Não é possível avançar o status do pedido. O pedido já foi entregue.");
        } else if (this == Cancelado) {
            throw new StatusInvalidoException("Não é possível avançar o status do pedido. O pedido foi cancelado.");
        } else {
            throw new StatusInvalidoException("\"Não há próximo status para \" + nome + \".\"\n");
        }
    }
}
