package br.com.fiap.orderservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.fiap.orderservice.enums.FormaPagamento;
import br.com.fiap.orderservice.enums.OrderStatus;
import br.com.fiap.orderservice.enums.StatusPagamento;

public class OrderFactory {
	
	private static List<Order> orderList = new ArrayList<>();
	
    public static List<Order> getCarrinhoList() {
		return orderList;
	}
    
    public static boolean create(Order order) {
    	if(!orderList.isEmpty()) {
    		//Order maxOrder = Collections.max(orderList, Comparator.comparing(v -> v.getIdOrder()));
    		order.getPagamento().setIdTransacao(getNewIdTransacao());
    		order.setIdOrder(getNewIdOrder());
    	} else {
    		order.getPagamento().setIdTransacao(1);
    		order.setIdOrder(1);
    	}
    	order.setStatus(OrderStatus.PENDING);
    	order.getPagamento().setStatusPagamento(StatusPagamento.WAITING);
    	return orderList.add(order);
    }

    public static Order update(Order order) {
    	for(Order or : orderList) {
    		if(or.getIdOrder() == order.getIdOrder()) {
    			or.setItens(order.getItens());
    			or.setPessoa(order.getPessoa());
    			or.setStatus(order.getStatus());
    			or.setDataCriacaoPedido(order.getDataCriacaoPedido());
    			
    			//só posso mudar o pagamento se o pagamento nao foi autorizado ainda    			
				if(!or.getPagamento().getStatusPagamento().equals(StatusPagamento.ACCEPTED)) {
					or.getPagamento().setIdTransacao(getNewIdTransacao());
					or.setPagamento(order.getPagamento());
				}
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
	
	public static long getNewIdTransacao() {
    	Order maxOrder = Collections.max(orderList, Comparator.comparing(v -> v.getIdOrder()));
    	return maxOrder.getPagamento().getIdTransacao() + 1;
    }
	
	public static int getNewIdOrder() {
		Order maxOrder = Collections.max(orderList, Comparator.comparing(v -> v.getIdOrder()));
		return maxOrder.getIdOrder() + 1;
	}
}
