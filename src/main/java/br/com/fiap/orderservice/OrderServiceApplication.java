package br.com.fiap.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		
		Person pess1 = new Person("Joao Victor de Souza", "joaovictor.souz@gmail.com", "Rua Nebraska 246");
		Produto p1 = new Produto("A1", "Produto A1", 90);		
		Produto p2 = new Produto("B2", "Produto B2", 72);
		Order order1 = new Order();
		
		order1.setIdOrder(1);
		order1.adicionarItem(p1, 2);
		order1.adicionarItem(p2, 7);
		OrderFactory.criarPedido(order1);

		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
