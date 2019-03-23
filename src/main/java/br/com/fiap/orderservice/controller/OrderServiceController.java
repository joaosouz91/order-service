package br.com.fiap.orderservice.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.orderservice.Order;
import br.com.fiap.orderservice.OrderFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order-service")
public class OrderServiceController {
	
    @GetMapping("/{idPedido}")
    public ResponseEntity getOrderById(@PathVariable(value="idPedido", required=true) int idOrder) {
        System.out.println("idOrder: " + idOrder);
        Order order = OrderFactory.findOrderById(idOrder);
        System.out.println(order.getIdOrder());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Order order) {
    	
    	OrderFactory.criarPedido(order);
    	
    	URI location = ServletUriComponentsBuilder
    			 .fromCurrentRequest()
    			 .path("/{idOrder}")
    			 .buildAndExpand(order.getIdOrder()).toUri();

    	return ResponseEntity.created(location).build();
    }
    
    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody Order order) {
    	
    	Order order1 = order;
    	OrderFactory.updatePedido(order1);
    	
    	URI location = ServletUriComponentsBuilder
    			 .fromCurrentRequest()
    			 .path("/{idOrder}")
    			 .buildAndExpand(order1.getIdOrder()).toUri();
    	return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestBody Order order) {
    	
    	Order order1 = order;
    	OrderFactory.deletePedido(order1);
    	
    	URI location = ServletUriComponentsBuilder
    			 .fromCurrentRequest()
    			 .path("/{idOrder}")
    			 .buildAndExpand(order1.getIdOrder()).toUri();
    	return ResponseEntity.created(location).build();
    }    
    
}
