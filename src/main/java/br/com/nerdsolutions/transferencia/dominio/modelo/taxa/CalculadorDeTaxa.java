package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import java.math.BigDecimal;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Interface comum aos calculadores de taxa de transfer�ncia banc�ria.
 * 
 * @author Newton Angelini
 * 
 */
public interface CalculadorDeTaxa {

	/**
	 * Calcula a taxa da transfer�ncia banc�ria.
	 * 
	 * @param transferencia
	 *            transfer�ncia banc�ria
	 * @return valor da taxa da transfer�ncia banc�ria
	 */
	BigDecimal calculaTaxaDa(Transferencia transferencia);

}
