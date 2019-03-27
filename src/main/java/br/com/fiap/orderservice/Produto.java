package br.com.fiap.orderservice;

import java.math.BigDecimal;

import br.com.fiap.orderservice.utils.Util;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private String codigo;
    private String descricao;
    private BigDecimal valorUnitario;
    
    public BigDecimal getValorUnitario(){
    	return Util.arredondar(valorUnitario);
    }
}
