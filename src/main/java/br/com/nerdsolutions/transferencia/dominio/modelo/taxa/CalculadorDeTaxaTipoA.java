package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import java.math.BigDecimal;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Calculador de taxa de transferência do tipo A.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoA implements CalculadorDeTaxa {

	/**
	 * @see CalculadorDeTaxa#calculaTaxaDa(Transferencia)
	 */
	public BigDecimal calculaTaxaDa(Transferencia transferencia) {
		return new BigDecimal("2.0").add(transferencia.getValor().multiply(
				new BigDecimal("0.03")));
	}

}
