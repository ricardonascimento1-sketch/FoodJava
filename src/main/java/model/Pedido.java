package model;

import exception.CancelamentoNaoPermitidoException;
import exception.StatusInvalidoException;

import java.io.ObjectInputFilter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido implements Identificador{
    private String id;
    private LocalDateTime data;
    private List<Item> itens;
    private ObjectInputFilter.Status status;

    public Pedido() {
        this.id = UUID.randomUUID().toString();
        this.data = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.status = ObjectInputFilter.Status.PENDENTE;
    }

    @Override
    public String getId() {
        return id;
    }


}
