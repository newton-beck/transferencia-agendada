package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Calculador de taxa de transferência do tipo B.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoB implements CalculadorDeTaxa {

	/**
	 * @see CalculadorDeTaxa#calculaTaxaDa(Transferencia)
	 */
	public BigDecimal calculaTaxaDa(Transferencia transferencia) {
		DateTime inicio = new DateTime(transferencia.getCriacao()
				.getTimeInMillis());
		DateTime fim = new DateTime(transferencia.getData().getTimeInMillis());

		if (Days.daysBetween(inicio, fim).getDays() > 30)
			return new BigDecimal("8.0");
		else
			return new BigDecimal("10.0");
	}

}
