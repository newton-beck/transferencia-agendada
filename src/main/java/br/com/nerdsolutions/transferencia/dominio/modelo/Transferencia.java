package br.com.nerdsolutions.transferencia.dominio.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Entidade que representa uma transfer�ncia financeira agendada entre duas
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
		 * Define o valor que ser� transferido entre as contas.
		 * 
		 * @param valor
		 *            valor que ser� transferido entre as contas
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
		 * Define a conta de destino da transfer�ncia.
		 * 
		 * @param destino
		 *            conta de destino da transfer�ncia
		 * @return {@link TransferenciaComDestino}
		 */
		public TransferenciaComDestino para(Conta destino) {
			return new TransferenciaComDestino(destino);
		}

	}

	public class TransferenciaComTipo {

		public TransferenciaComTipo(Tipo tipo) {
			Transferencia.this.tipo = tipo;

			// TODO Calcular o valor da taxa da transfer�ncia
		}

		/**
		 * Define a data na qual ser� realizada a transfer�ncia.
		 * 
		 * @param data
		 *            data na qual ser� realizada a transfer�ncia.
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
		 * Define o tipo da transfer�ncia banc�ria.
		 * 
		 * @param tipo
		 *            tipo da transfer�ncia banc�ria
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
		 * Cria a transfer�ncia banc�ria.
		 * 
		 * @return {@link Transferencia}
		 */
		public Transferencia cria() {
			return Transferencia.this;
		}

	}

	/**
	 * Conta de origem da transfer�ncia.
	 */
	private Conta origem;

	/**
	 * Conta de destino da transfer�ncia.
	 */
	private Conta destino;

	/**
	 * Valor da transfer�ncia.
	 */
	private BigDecimal valor;

	/**
	 * Valor da taxa aplicada na transfer�ncia.
	 */
	private BigDecimal taxa;

	/**
	 * Data na qual ser� realizada a transfer�ncia.
	 */
	private Calendar data;

	/**
	 * Data de cria��o da transfer�ncia.
	 */
	private Calendar criacao;

	/**
	 * Tipo da transfer�ncia.
	 */
	private Tipo tipo;

	public Transferencia() {
		criacao = Calendar.getInstance();
	}

	/**
	 * Define a conta de origem da transfer�ncia.
	 * 
	 * @param origem
	 *            conta de origem da transfer�ncia
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
