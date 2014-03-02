package br.com.nerdsolutions.transferencia.dominio.modelo;

/**
 * Entidade que representa uma conta banc�ria.
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
		 * Define o d�gito verificador do n�mero da conta banc�ria.
		 * 
		 * @param digitoVerificador
		 *            d�gito verificador do n�mero da conta banc�ria
		 * @return {@link Conta}
		 */
		public Conta comDigitoVerificador(Integer digitoVerificador) {
			Conta.this.digitoVerificador = digitoVerificador;
			return Conta.this;
		}

	}

	/**
	 * N�mero da conta banc�ria.
	 */
	private Integer numero;

	/**
	 * D�gito verificador da conta banc�ria.
	 */
	private Integer digitoVerificador;

	/**
	 * Define o n�mero da conta banc�ria sem d�gito verificador.
	 * 
	 * @param numero
	 *            n�mero da conta banc�ria sem d�gito verificador
	 * @return {@link ContaComNumero}
	 */
	public ContaComNumero comNumero(Integer numero) {
		return new ContaComNumero(numero);
	}

	/**
	 * Recupera o n�mero da conta no formato XXXXX-X.
	 * 
	 * @return n�mero da conta no formato XXXXX-X
	 */
	public String getNumeroFormatado() {
		return numero + "-" + digitoVerificador;
	}

}
