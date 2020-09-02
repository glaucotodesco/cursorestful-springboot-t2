package com.example.cursorestfulspringboott2.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    List<Cliente> clientes;

    @PostConstruct
    public void init() {

        Cliente c1 = new Cliente();
        c1.id = 1;
        c1.nome = "Jose";
        c1.endereco = "Rua X, 99";
        c1.saldo = 100;

        Cliente c2 = new Cliente();
        c2.id = 2;
        c2.nome = "Maria";
        c2.endereco = "Rua Y, 24";
        c2.saldo = 200;

        Cliente c3 = new Cliente();
        c3.id = 3;
        c3.nome = "Fernada";
        c3.endereco = "Rua W, 57";
        c3.saldo = 300;

        clientes = Arrays.asList(c1, c2, c3);

    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clientes;
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable int id) {
        Cliente cliente = null;

        for(Cliente aux : clientes){
            if(aux.id == id){
                cliente = aux;
                break;
            }
        }

        return cliente;
    }

}