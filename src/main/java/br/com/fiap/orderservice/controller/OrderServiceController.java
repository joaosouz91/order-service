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
	
    @GetMapping("/{idOrder}")
    public ResponseEntity getOrderById(@PathVariable(value="idOrder", required=true) int idOrder) {
        Order order = OrderFactory.findOrderById(idOrder);
        if(order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Order order) {
    	
    	if(OrderFactory.create(order)) {
    		URI location = ServletUriComponentsBuilder
       			 .fromCurrentRequest()
       			 .path("/{idOrder}")
       			 .buildAndExpand(order.getIdOrder()).toUri();
    		return ResponseEntity.created(location).build();
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	
    }
    
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Order order) {
    	
    	order = OrderFactory.update(order);
    	
    	if(order != null) {
    		URI location = ServletUriComponentsBuilder
       			 .fromCurrentRequest()
       			 .path("/{idOrder}")
       			 .buildAndExpand(order.getIdOrder()).toUri();
    		return ResponseEntity.created(location).build();
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	
    }
    
    @DeleteMapping("{idOrder}")
    public ResponseEntity<String> delete(@PathVariable(value="idOrder", required=true) int idOrder) {
    	
    	if(OrderFactory.delete(idOrder)) {
    		return new ResponseEntity<>(HttpStatus.ACCEPTED);
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }    
    
}
