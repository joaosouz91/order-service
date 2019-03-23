package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @GetMapping("/findById/{idPedido}")
    public ResponseEntity getHello(@PathVariable(value="idPedido", required=true) int idPedido) {

        System.out.printf("Hello %s", idPedido);
        return new ResponseEntity<>(idPedido, HttpStatus.OK);
        //return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/person")
    public ResponseEntity<Person> getHelloPerson(Person person) {

        log.info("Hello {}", person.getNomeCompleto());

        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
