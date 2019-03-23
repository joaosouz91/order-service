package br.com.fiap.orderservice;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Person pessoa;
    private int idOrder;
    private List<Item> itens = new ArrayList<Item>();
    private float valorTotal;
    private String formaPagamento;
    private String dataCriacaoPedido;
    private String status;

    public float getValorTotal(){
    	valorTotal = 0;
        for(Item item : itens){
        	valorTotal += item.getQuantidade() * item.getProduto().getValorUnitario();
        }
        return valorTotal;
    }
    
    public void adicionarItem(Produto produto, int quantidade) {

		boolean exists = false;
		Item item = new Item(produto, quantidade);
		try {
			for (Item i : itens) {
				//verifica se o item existe na lista
				if(i.equals(item)) {
					exists = true;	
					//atualiza a quantidade
					i.setQuantidade(i.getQuantidade() + quantidade);
				}
			}
			if(!exists) {
				itens.add(item);
			}
		}catch (IllegalArgumentException e) {
			System.out.println("=== Não foi possível adicionar o item ao carrinho ===");
		}catch(Exception e) {
			System.out.println("=== Não foi possível adicionar o item ao carrinho ===");
		}
		
    }
}
