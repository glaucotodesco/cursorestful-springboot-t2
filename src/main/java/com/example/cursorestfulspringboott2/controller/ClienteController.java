package com.example.cursorestfulspringboott2.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.cursorestfulspringboott2.model.Cliente;
import com.example.cursorestfulspringboott2.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return repository.getClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable int id) {
        return repository.getClienteById(id);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

}