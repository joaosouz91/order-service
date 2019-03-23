package br.com.fiap.orderservice;

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
public class Item {
    private Produto produto;
    private int quantidade;
    
    public boolean equals(Object obj) {
    	if(!(obj instanceof Item)) {
    		return false;
    	}
    	final Item item = (Item)obj;
    	return this.getProduto().getCodigo().equals(item.getProduto().getCodigo());
    }
}
