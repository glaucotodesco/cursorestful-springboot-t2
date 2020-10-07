package com.example.cursorestfulspringboott2.service;

import com.example.cursorestfulspringboott2.dto.ClienteDTO;
import com.example.cursorestfulspringboott2.model.Cliente;

import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    public Cliente fromDTO(ClienteDTO objDTO){
        
        Cliente cliente = new Cliente();
        cliente.setEndereco(objDTO.getEndereco());
        cliente.setNome(objDTO.getNome());

        return cliente;
    }
    
}
