package br.com.fiap.orderservice;

import br.com.fiap.orderservice.enums.BandeiraCartao;
import br.com.fiap.orderservice.enums.FormaPagamento;
import br.com.fiap.orderservice.enums.StatusPagamentoCartao;
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
	private StatusPagamentoCartao statusPagamentoCartao;

	public Pagamento(FormaPagamento formaPagamento){
		this.formaPagamento = formaPagamento;
		if(formaPagamento.equals(FormaPagamento.CREDITO) || formaPagamento.equals(FormaPagamento.CREDITO)) {
			statusPagamentoCartao = StatusPagamentoCartao.WAITING;
		}
	}

}