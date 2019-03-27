package br.com.fiap.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		
		/*
		Person pess1 = new Person("Joao Victor de Souza", "joaovictor.souz@gmail.com", "Rua Nebraska 246");
		Produto p1 = new Produto("A1", "Produto A1", 90);		
		Produto p2 = new Produto("B2", "Produto B2", 72);
		
		Pagamento pgmt = new Pagamento(FormaPagamento.CREDITO);
		pgmt.setBandeiraCartao(BandeiraCartao.MASTERCARD);
		pgmt.setValidadeCartao("2027-03");
		pgmt.setNumeroCartao("1234 2343 3422 3213");
		
		Order order = new Order();
		
		order.setPessoa(pess1);
		order.setIdOrder(1);
		order.adicionarItem(p1, 2);
		order.adicionarItem(p2, 7);
		order.setPagamento(pgmt);
		order.setStatus(OrderStatus.PENDING);
		order.setDataCriacaoPedido("2019-03-01 23:43:49.767");
		
		OrderFactory.create(order);
		*/
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
