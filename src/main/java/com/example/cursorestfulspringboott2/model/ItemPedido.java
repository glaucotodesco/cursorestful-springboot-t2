package com.example.cursorestfulspringboott2.model;


public class ItemPedido {
    
    private int numero;
    private double precoUnitario;
    private String produto;
    private int quantidade;
    

    public ItemPedido(){
        
    }

    public ItemPedido(int numero, double preco, String produto, int quantidade) {
		this.numero = numero;
		this.precoUnitario = preco;
		this.produto = produto;
		this.quantidade = quantidade;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

 
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

    public double getTotalItem(){
        return precoUnitario * quantidade;
    }
   
}
