package br.com.fiap.orderservice;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String nomeCompleto;
    private String email;
    private String enderecoCompleto;
}
