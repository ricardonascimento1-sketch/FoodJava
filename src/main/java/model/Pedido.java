package model;

import exception.CancelamentoNaoPermitidoException;
import exception.StatusInvalidoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Pedido implements Identificador{
    private String id;
    private String clienteEmail;
    private LocalDateTime data;
    private List<ItemPedido> itens;
    private double valorTotal;
    private StatusPedido status = StatusPedido.Aguardando_Pedido;

    public Pedido(){

    }
    public Pedido(String clienteEmail, List<ItemPedido> itens) {
        this.clienteEmail = clienteEmail;
        this.itens = new ArrayList<>(itens);
        recalcularTotal();
    }

    public String getId() {
        return id;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }
    public void avancarStatus() throws StatusInvalidoException {
        status = status.proximo();
    }
    public void cancelar() throws CancelamentoNaoPermitidoException {
        if (status != StatusPedido.Pronto) {
            throw new CancelamentoNaoPermitidoException("Pedido só pode ser cancelado enquanto aguarda confirmação.");
        }
        status = StatusPedido.Cancelado;
    }
    public boolean estaAberto() {
        return status != StatusPedido.Entregue && status != StatusPedido.Cancelado;
    }
    private void recalcularTotal() {
        valorTotal = itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id.substring(0, 8) + '\'' +
                ", emailCliente='" + clienteEmail + '\'' +
                ", data=" + data +
                ", itens=" + itens +
                ", status=" + status +
                '}';
    }
}
