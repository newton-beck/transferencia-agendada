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

	/**
	 * Recupera o número da conta no formato XXXXX-X.
	 * 
	 * @return número da conta no formato XXXXX-X
	 */
	public String getNumeroFormatado() {
		return numero + "-" + digitoVerificador;
	}

}
