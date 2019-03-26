package br.com.fiap.orderservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.orderservice.enums.FormaPagamento;
import br.com.fiap.orderservice.enums.OrderStatus;
import br.com.fiap.orderservice.utils.Util;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private int idOrder;
	private Person pessoa;
    private List<Item> itens = new ArrayList<Item>();
    private BigDecimal valorTotal;
    private Pagamento pagamento;
    private String dataCriacaoPedido;
    private OrderStatus status;

    public BigDecimal getValorTotal(){
    	valorTotal = BigDecimal.ZERO;
        for(Item item : itens){
        	valorTotal = valorTotal.add(item.getProduto().getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
        }
        return Util.arredondar(valorTotal);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (idOrder != other.idOrder)
			return false;
		return true;
	}

}
