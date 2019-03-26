package br.com.fiap.orderservice;

import br.com.fiap.orderservice.enums.BandeiraCartao;
import br.com.fiap.orderservice.enums.FormaPagamento;
import br.com.fiap.orderservice.enums.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Pagamento {
	
	private FormaPagamento formaPagamento;
	private String numeroCartao;
	private String validadeCartao;
	private BandeiraCartao bandeiraCartao;
	private long idTransacao;
	private StatusPagamento statusPagamento;

	public Pagamento(){
		statusPagamento = StatusPagamento.WAITING;
	}

}
