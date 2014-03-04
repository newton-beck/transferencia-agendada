package br.com.nerdsolutions.transferencia.infraestrutura.dto;

import java.util.Calendar;

import br.com.nerdsolutions.transferencia.dominio.modelo.Tipo;

/**
 * Data Transfer Object utilizado pelo VRaptor para converter os dados de
 * formulário em objetos e evitar ataques de mass-assignment.
 * 
 * @author Newton Angelini
 * 
 */
public class TransferenciaDTO {

	private ContaDTO origem;

	private ContaDTO destino;

	private Double valor;

	private Calendar data;

	private Tipo tipo;

	public Calendar getData() {
		return data;
	}

	public ContaDTO getDestino() {
		return destino;
	}

	public ContaDTO getOrigem() {
		return origem;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public void setDestino(ContaDTO destino) {
		this.destino = destino;
	}

	public void setOrigem(ContaDTO origem) {
		this.origem = origem;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
