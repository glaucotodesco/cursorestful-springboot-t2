package com.example.cursorestfulspringboott2.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.cursorestfulspringboott2.dto.ClienteDTO;
import com.example.cursorestfulspringboott2.model.Cliente;
import com.example.cursorestfulspringboott2.repository.ClienteRepository;
import com.example.cursorestfulspringboott2.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService servico;

    @GetMapping
    public List<Cliente> getClientes() {
        return repository.getClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int id) {
        Cliente cliente = repository.getClienteById(id);     
        
        if(cliente == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) {

         Cliente cliente = servico.fromDTO(clienteDTO);

         cliente = repository.save(cliente);
         
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+cliente.getId()).build();

         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        Cliente cliente = repository.getClienteById(id);
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        else{
            repository.delete(cliente);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody ClienteDTO clienteDTO, @PathVariable int id){ 
        Cliente aux = repository.getClienteById(id);
        if(aux != null){
            Cliente cliente = servico.fromDTO(clienteDTO);
            cliente.setId(id);
            cliente = repository.update(cliente);
            return ResponseEntity.ok(cliente);
        }
        else{
            return ResponseEntity.notFound().build();           
        }
    }

}