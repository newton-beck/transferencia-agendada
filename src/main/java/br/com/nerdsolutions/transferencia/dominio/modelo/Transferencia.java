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

			Transferencia.this.taxa = tipo.calculaTaxaDa(Transferencia.this);
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

	public class TransferenciaComValor {

		public TransferenciaComValor(BigDecimal valor) {
			Transferencia.this.valor = valor;
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

	public class TransferenciaNaData {

		public TransferenciaNaData(Calendar data) {
			Transferencia.this.data = data;
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

	public Calendar getCriacao() {
		return criacao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((taxa == null) ? 0 : taxa.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (taxa == null) {
			if (other.taxa != null)
				return false;
		} else if (!taxa.equals(other.taxa))
			return false;
		if (tipo != other.tipo)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
