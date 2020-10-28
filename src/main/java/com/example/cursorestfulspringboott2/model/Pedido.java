package com.example.cursorestfulspringboott2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Pedido {
    private long numero;
    private String descricao;
    private LocalDateTime dataPedido;
    private boolean pedidoFechado;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();

    public Pedido() {

    }

    public Pedido(long numero) {
        this.numero = numero;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isPedidoFechado() {
        return pedidoFechado;
    }

    public void setPedidoFechado(boolean pedidoFechado) {
        this.pedidoFechado = pedidoFechado;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public boolean addItemPedido(int numero, double preco, String produto, int quantidade) {
        return itens.add(new ItemPedido(numero, preco, produto, quantidade));
    }

    @JsonGetter
    public double totalPedido() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.getTotalItem();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente.getId() + ", dataPedido=" + dataPedido + ", descricao=" + descricao
                + ", numero=" + numero + "]";
    }
}