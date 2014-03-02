package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import java.math.BigDecimal;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Calculador de taxa de transferência do tipo C.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoD implements CalculadorDeTaxa {

	/**
	 * @see CalculadorDeTaxa#calculaTaxaDa(Transferencia)
	 */
	public BigDecimal calculaTaxaDa(Transferencia transferencia) {
		if (transferencia.getValor().compareTo(new BigDecimal("120000")) > 0)
			return new CalculadorDeTaxaTipoA().calculaTaxaDa(transferencia);
		else if (transferencia.getValor().compareTo(new BigDecimal("25000")) > 0)
			return new CalculadorDeTaxaTipoB().calculaTaxaDa(transferencia);
		else
			return new CalculadorDeTaxaTipoC().calculaTaxaDa(transferencia);
	}

}
