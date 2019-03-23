package br.com.fiap.orderservice;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Person pessoa;
    private List<Item> itens;
    private float valorTotal;
    private String formaPagamento;
    private String dataCriacaoPedido;
    private String status;

    public float getValorTotal(){
    	valorTotal = 0;
        for(Item item : itens){
        	valorTotal += item.getQuantidade() * item.getValorUnitario();
        }
        return valorTotal;
    }
    
    public void adicionarItem(Produto produto, float valorUnitario, int quantidade) {

		boolean exists = false;
		Item item = new Item(produto, valorUnitario, quantidade);
		try {
			for (Item i : itens) {
				//verifica se o item existe na lista
				if(i.equals(item)) {
					exists = true;
					
					//atualiza a quantidade
					i.setQuantidade(i.getQuantidade() + quantidade);

					//atualiza o valor se for diferente
					if(i.getValorUnitario() != valorUnitario) {
						i.setValorUnitario(valorUnitario);
					}
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
