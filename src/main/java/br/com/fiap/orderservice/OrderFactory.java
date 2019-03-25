package br.com.fiap.orderservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.fiap.orderservice.enums.FormaPagamento;
import br.com.fiap.orderservice.enums.StatusPagamentoCartao;

public class OrderFactory {
	
	private static List<Order> orderList = new ArrayList<>();
	
    public static List<Order> getCarrinhoList() {
		return orderList;
	}
    
    public static boolean create(Order order) {
    	if(!orderList.isEmpty()) {
    		Order maxOrder = Collections.max(orderList, Comparator.comparing(v -> v.getIdOrder()));
    		order.getPagamento().setIdTransacao(maxOrder.getPagamento().getIdTransacao() + 1);
    		order.setIdOrder(maxOrder.getIdOrder() + 1);
    	} else {
    		order.getPagamento().setIdTransacao(1);
    		order.setIdOrder(1);
    	}
    	return orderList.add(order);
    }
    
    public static Order update(Order order) {
    	for(Order or : orderList) {
    		if(or.getIdOrder() == order.getIdOrder()) {
    			or.setItens(order.getItens());
    			or.setPessoa(order.getPessoa());
    			or.setStatus(order.getStatus());
    			
    			//para cartao so posso mudar o idTransacao se o pagamento nao foi autorizado ainda
    			FormaPagamento formaPagamentoRequest = order.getPagamento().getFormaPagamento();
    			FormaPagamento formaPagamentoAtual = or.getPagamento().getFormaPagamento();
    			
    			if(formaPagamentoRequest.equals(FormaPagamento.CREDITO) || formaPagamentoRequest.equals(FormaPagamento.DEBITO)) {
    					
    					//verifica status da transacao
    					if(!or.getPagamento().getStatusPagamentoCartao().equals(StatusPagamentoCartao.ACCEPTED)) {
    						or.setPagamento(order.getPagamento());
    					}
    			}
    			//or.setPagamento(order.getPagamento());
    			or.setDataCriacaoPedido(order.getDataCriacaoPedido());
    			return or;
    		}
    	}
		return null;
    }
    
    public static Order findOrderById(int idOrder) {		
    	for(Order order : orderList) {
    		if(idOrder == order.getIdOrder()) {
    			return order;
    		}
    	}
    	return null;
    }

	public static boolean delete(int idOrder) {
		for(Order order : orderList) {
			if(idOrder == order.getIdOrder()) {
				return orderList.remove(order);
			}
		}
		return false;
	}
}
