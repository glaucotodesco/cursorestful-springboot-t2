package com.example.cursorestfulspringboott2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.cursorestfulspringboott2.model.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {

    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private int nextNumero=1;

    public Pedido save(Pedido pedido) {
        pedido.setNumero(nextNumero);
        pedidos.add(pedido);
        nextNumero++;
        return pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Optional<Pedido> getPedidoByNumero(long numero) {
        for (Pedido aux : pedidos) {
            if (aux.getNumero() == numero) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }
}
