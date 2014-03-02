package br.com.nerdsolutions.transferencia.dominio.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Entidade que representa uma transferência financeira agendada entre duas
 * contas.
 * 
 * @author Newton Angelini
 * 
 */
public class Transferencia {

	public class TransferenciaComDestino {

		public TransferenciaComDestino(Conta destino) {
			Transferencia.this.destino = destino;
		}

		/**
		 * Define o valor que será transferido entre as contas.
		 * 
		 * @param valor
		 *            valor que será transferido entre as contas
		 * @return {@link TransferenciaComValor}
		 */
		public TransferenciaComValor comValor(BigDecimal valor) {
			return new TransferenciaComValor(valor);
		}

	}

	public class TransferenciaComOrigem {

		public TransferenciaComOrigem(Conta origem) {
			Transferencia.this.origem = origem;
		}

		/**
		 * Define a conta de destino da transferência.
		 * 
		 * @param destino
		 *            conta de destino da transferência
		 * @return {@link TransferenciaComDestino}
		 */
		public TransferenciaComDestino para(Conta destino) {
			return new TransferenciaComDestino(destino);
		}

	}

	public class TransferenciaComTipo {

		public TransferenciaComTipo(Tipo tipo) {
			Transferencia.this.tipo = tipo;

			// TODO Calcular o valor da taxa da transferência
		}

		/**
		 * Define a data na qual será realizada a transferência.
		 * 
		 * @param data
		 *            data na qual será realizada a transferência.
		 * @return {@link TransferenciaNaData}
		 */
		public TransferenciaNaData naData(Calendar data) {
			return new TransferenciaNaData(data);
		}

	}

	public class TransferenciaComValor {

		public TransferenciaComValor(BigDecimal valor) {
			Transferencia.this.valor = valor;
		}

		/**
		 * Define o tipo da transferência bancária.
		 * 
		 * @param tipo
		 *            tipo da transferência bancária
		 * @return {@link TransferenciaComTipo}
		 */
		public TransferenciaComTipo doTipo(Tipo tipo) {
			return new TransferenciaComTipo(tipo);
		}

	}

	public class TransferenciaNaData {

		public TransferenciaNaData(Calendar data) {
			Transferencia.this.data = data;
		}

		/**
		 * Cria a transferência bancária.
		 * 
		 * @return {@link Transferencia}
		 */
		public Transferencia cria() {
			return Transferencia.this;
		}

	}

	/**
	 * Conta de origem da transferência.
	 */
	private Conta origem;

	/**
	 * Conta de destino da transferência.
	 */
	private Conta destino;

	/**
	 * Valor da transferência.
	 */
	private BigDecimal valor;

	/**
	 * Valor da taxa aplicada na transferência.
	 */
	private BigDecimal taxa;

	/**
	 * Data na qual será realizada a transferência.
	 */
	private Calendar data;

	/**
	 * Data de criação da transferência.
	 */
	private Calendar criacao;

	/**
	 * Tipo da transferência.
	 */
	private Tipo tipo;

	public Transferencia() {
		criacao = Calendar.getInstance();
	}

	/**
	 * Define a conta de origem da transferência.
	 * 
	 * @param origem
	 *            conta de origem da transferência
	 * @return {@link TransferenciaComOrigem}
	 */
	public TransferenciaComOrigem de(Conta origem) {
		return new TransferenciaComOrigem(origem);
	}

	public Calendar getData() {
		return data;
	}

	public Conta getDestino() {
		return destino;
	}

	public Conta getOrigem() {
		return origem;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
