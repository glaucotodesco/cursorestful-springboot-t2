package com.example.cursorestfulspringboott2.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import com.example.cursorestfulspringboott2.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

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

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

    }

    public Cliente save(Cliente cliente) {
        cliente.id = clientes.size() + 1;
        clientes.add(cliente);
        return cliente;

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getClienteById(int id) {

        for (Cliente aux : clientes) {
            if (aux.id == id) {
                return aux;
            }
        }

        return null;
    }

}
