package com.example.cursorestfulspringboott2.service;

import java.util.List;
import java.util.Optional;

import com.example.cursorestfulspringboott2.dto.ClienteDTO;
import com.example.cursorestfulspringboott2.model.Cliente;
import com.example.cursorestfulspringboott2.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente fromDTO(ClienteDTO objDTO){
        Cliente cliente = new Cliente();
        cliente.setEndereco(objDTO.getEndereco());
        cliente.setNome(objDTO.getNome());
        return cliente;
    }

	public List<Cliente> getClientes() {
		return repository.getClientes();
	}

	public Cliente getClienteById(int id) {
        Optional<Cliente> op = repository.getClienteById(id);
        return op.orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não cadastrado!"));
	}

	public Cliente save(Cliente cliente) {
      	return repository.save(cliente);
	}

	public void removerById(int id) {
         repository.delete(getClienteById(id)); 
	}

	public Cliente update(Cliente cliente) {
        getClienteById(cliente.getId()); //So para lancar o 404
		return repository.update(cliente);
	}
    


}
