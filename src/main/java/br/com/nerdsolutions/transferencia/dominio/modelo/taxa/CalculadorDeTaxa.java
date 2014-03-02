package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import java.math.BigDecimal;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Interface comum aos calculadores de taxa de transferência bancária.
 * 
 * @author Newton Angelini
 * 
 */
public interface CalculadorDeTaxa {

	/**
	 * Calcula a taxa da transferência bancária.
	 * 
	 * @param transferencia
	 *            transferência bancária
	 * @return valor da taxa da transferência bancária
	 */
	BigDecimal calculaTaxaDa(Transferencia transferencia);

}
