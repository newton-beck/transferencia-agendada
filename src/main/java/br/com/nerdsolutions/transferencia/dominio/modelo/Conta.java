package br.com.nerdsolutions.transferencia.dominio.modelo;

/**
 * Entidade que representa uma conta bancária.
 * 
 * @author Newton Angelini
 * 
 */
public class Conta {

	public class ContaComNumero {

		public ContaComNumero(Integer numero) {
			Conta.this.numero = numero;
		}

		/**
		 * Define o dígito verificador do número da conta bancária.
		 * 
		 * @param digitoVerificador
		 *            dígito verificador do número da conta bancária
		 * @return {@link Conta}
		 */
		public Conta comDigitoVerificador(Integer digitoVerificador) {
			Conta.this.digitoVerificador = digitoVerificador;
			return Conta.this;
		}

	}

	/**
	 * Número da conta bancária.
	 */
	private Integer numero;

	/**
	 * Dígito verificador da conta bancária.
	 */
	private Integer digitoVerificador;

	/**
	 * Define o número da conta bancária sem dígito verificador.
	 * 
	 * @param numero
	 *            número da conta bancária sem dígito verificador
	 * @return {@link ContaComNumero}
	 */
	public ContaComNumero comNumero(Integer numero) {
		return new ContaComNumero(numero);
	}

	public Integer getDigitoVerificador() {
		return digitoVerificador;
	}

	public Integer getNumero() {
		return numero;
	}

	/**
	 * Recupera o número da conta no formato XXXXX-X.
	 * 
	 * @return número da conta no formato XXXXX-X
	 */
	public String getNumeroFormatado() {
		return numero + "-" + digitoVerificador;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (digitoVerificador == null) {
			if (other.digitoVerificador != null)
				return false;
		} else if (!digitoVerificador.equals(other.digitoVerificador))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((digitoVerificador == null) ? 0 : digitoVerificador
						.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

}
