package br.com.fiap.orderservice;

import java.math.BigDecimal;

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
}
