package br.com.fiap.orderservice;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private String codigo;
    private String descricao;
    private float valorUnitario;
}
