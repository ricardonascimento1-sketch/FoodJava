package Controller;

import exception.CancelamentoNaoPermitidoException;
import exception.CarrinhoVazioException;
import exception.StatusInvalidoException;
import model.ItemCardapio;
import model.ItemPedido;
import model.Pedido;
import model.StatusPedido;
import repository.AppData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PedidoController {

    public PedidoController(AppData db) {
        this.db = db;
    }

    private final AppData db;
    private final List<ItemPedido> carrinho = new ArrayList<>();

    public List<ItemPedido> getCarrinho() {
        return carrinho;
    }
    public void adicionarAoCarrinho(ItemCardapio item) {
        carrinho.stream()
                .filter(i -> i.getItemId().equals(item.getId()))
                .findFirst()
                .ifPresentOrElse(ItemPedido::incrementar, () -> carrinho.add(new ItemPedido(item, 1)));
    }
    public void removerDoCarrinho(ItemPedido item) {
        carrinho.remove(item);
    }
    public Pedido confirmarPedido(String clienteEmail) throws CarrinhoVazioException {
        if (carrinho.isEmpty()) {
            throw new CarrinhoVazioException("Carrinho vazio.");
        }
        Pedido pedido = new Pedido(clienteEmail, carrinho);
        List<Pedido> pedidos = db.pedidos().listar();
        pedidos.add(pedido);
        db.pedidos().salvarTodos(pedidos);
        carrinho.clear();
        return pedido;
    }
    public List<Pedido> listarTodos(StatusPedido filtro) {
        return db.pedidos().listar().stream()
                .filter(p -> filtro == null || p.getStatus() == filtro)
                .sorted(Comparator.comparing(Pedido::getDataHora).reversed())
                .toList();
    }
    public List<Pedido> listarDoCliente(String email) {
        return listarTodos(null).stream()
                .filter(p -> p.getClienteEmail().equalsIgnoreCase(email))
                .toList();
    }
    public void avancar(Pedido pedido) throws StatusInvalidoException {
        List<Pedido> pedidos = db.pedidos().listar();
        for (Pedido p : pedidos) {
            if (p.getId().equals(pedido.getId())) {
                p.avancarStatus();
            }
        }
        db.pedidos().salvarTodos(pedidos);
    }
    public void cancelar(Pedido pedido) throws CancelamentoNaoPermitidoException {
        List<Pedido> pedidos = db.pedidos().listar();
        for (Pedido p : pedidos) {
            if (p.getId().equals(pedido.getId())) {
                p.cancelar();
            }
        }
        db.pedidos().salvarTodos(pedidos);
    }
    public long totalPedidosHoje() {
        return db.pedidos().listar().stream()
                .filter(p -> p.getDataHora().toLocalDate().equals(LocalDate.now()))
                .count();
    }
    public double faturamentoHoje() {
        return db.pedidos().listar().stream()
                .filter(p -> p.getDataHora().toLocalDate().equals(LocalDate.now()))
                .filter(p -> p.getStatus() != StatusPedido.Cancelado)
                .mapToDouble(Pedido::getValorTotal)
                .sum();
    }
}
