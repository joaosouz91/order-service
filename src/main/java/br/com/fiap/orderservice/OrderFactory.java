package br.com.fiap.orderservice;

import java.util.ArrayList;
import java.util.List;

public class OrderFactory {
	
	private static List<Order> orderList = new ArrayList<>();
	
    public static List<Order> getCarrinhoList() {
		return orderList;
	}
    
    public static void criarPedido(Order order) {
    	orderList.add(order);
    }
    
    public static Order updatePedido(Order order) {
    	for(Order or : orderList) {
    		if(or.getIdOrder() == order.getIdOrder()) {
    			or.setItens(order.getItens());
    			or.setPessoa(order.getPessoa());
    			or.setStatus(order.getStatus());
    			or.setFormaPagamento(order.getFormaPagamento());
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

	public static void deletePedido(Order order1) {
		
		
	}
}
