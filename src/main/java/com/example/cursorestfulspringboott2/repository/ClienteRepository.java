package com.example.cursorestfulspringboott2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import com.example.cursorestfulspringboott2.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

    private List<Cliente> clientes;
    private int nextId;

    @PostConstruct
    public void init() {

        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X, 99");
        c1.setSaldo(100);

        Cliente c2 = new Cliente();
        c2.setId(2);
        c2.setNome("Maria");
        c2.setEndereco("Rua Y, 919");
        c2.setSaldo(100);

        Cliente c3 = new Cliente();
        c3.setId(3);
        c3.setNome("Fernanda");
        c3.setEndereco("Rua W, 44");
        c3.setSaldo(300);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        nextId = 4;

    }

    public Cliente save(Cliente cliente) {
        cliente.setId(nextId);
        clientes.add(cliente);
        nextId++;
        return cliente;

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteById(int id) {
        for (Cliente aux : clientes) {
            if (aux.getId() == id) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

	public void delete(Cliente cliente) {
        clientes.remove(cliente);
	}

	public Cliente update(Cliente cliente) {
        
        Cliente aux = getClienteById(cliente.getId()).get();

        if(aux != null){
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
        }

        return aux;
        
	}

}
