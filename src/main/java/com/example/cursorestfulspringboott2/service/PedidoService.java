package com.example.cursorestfulspringboott2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.cursorestfulspringboott2.model.Cliente;
import com.example.cursorestfulspringboott2.model.Pedido;
import com.example.cursorestfulspringboott2.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PedidoService {

   
    @Autowired
    private PedidoRepository repository;
   
    @Autowired
    private ClienteService clienteService;


    public List<Pedido> getAllPedidos(){
        return repository.getPedidos();
    }

    public Pedido getPedidoByNumero(long numero) {
        Optional<Pedido> op = repository.getPedidoByNumero(numero);
        return op.orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não cadastrado!"));
	}

    public Pedido save(Pedido pedido, int idCliente) {
        
        //Verifica se existe um cliente com o idCliente
        //Se nao existir gera o 404 NotFound e FINALIZA o SAVE!
        Cliente cliente = clienteService.getClienteById(idCliente);

        pedido.setDataPedido(LocalDateTime.now());

        //Associar um pedido a um cliente e um cliente ao pedido
        pedido.setCliente(cliente);
        cliente.addPedido(pedido);
        
        return repository.save(pedido);
  }
    
}
