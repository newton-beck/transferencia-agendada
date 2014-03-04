package br.com.nerdsolutions.transferencia.infraestrutura.dto;


/**
 * Data Transfer Object utilizado pelo VRaptor para converter os dados de
 * formulário em objetos e evitar ataques de mass-assignment.
 * 
 * @author Newton Angelini
 * 
 */
public class ContaDTO {

	private Integer numero;

	private Integer digitoVerificador;

	public Integer getDigitoVerificador() {
		return digitoVerificador;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setDigitoVerificador(Integer digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
