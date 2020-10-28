package com.example.cursorestfulspringboott2.controller;

import java.util.List;

import com.example.cursorestfulspringboott2.model.Pedido;
import com.example.cursorestfulspringboott2.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> getAllPedidos(){
        return service.getAllPedidos();
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Pedido> getClienteById(@PathVariable long numero) {
        Pedido pedido = service.getPedidoByNumero(numero);
        return ResponseEntity.ok(pedido);
    }








}
