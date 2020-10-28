package com.example.cursorestfulspringboott2.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.example.cursorestfulspringboott2.dto.ClienteDTO;
import com.example.cursorestfulspringboott2.model.Cliente;
import com.example.cursorestfulspringboott2.model.Pedido;
import com.example.cursorestfulspringboott2.service.ClienteService;
import com.example.cursorestfulspringboott2.service.PedidoService;

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
    private ClienteService servico;


    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    public List<Cliente> getClientes() {
        return servico.getClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Cliente cliente = servico.getClienteById(id);     
        return ResponseEntity.ok(cliente);
    }


    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) {
         Cliente cliente = servico.fromDTO(clienteDTO);
         cliente = servico.save(cliente);
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+cliente.getId()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        servico.removerById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody ClienteDTO clienteDTO, @PathVariable int id){ 
        Cliente cliente = servico.fromDTO(clienteDTO);
        cliente.setId(id);
        cliente = servico.update(cliente);
        return ResponseEntity.ok(cliente);
    }


    @PostMapping("{id}/pedidos")
    public ResponseEntity<Pedido> salvar(  @PathVariable int id,
                                           @RequestBody Pedido pedido,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) {

         //Esse metodo pode gerar o 404 para o id do cliente!
         pedidoService.save(pedido, id);                                    
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+pedido.getNumero()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }

}