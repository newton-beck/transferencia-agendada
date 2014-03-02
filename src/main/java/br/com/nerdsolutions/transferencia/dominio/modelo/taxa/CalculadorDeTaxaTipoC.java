package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Calculador de taxa de transferência do tipo C.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoC implements CalculadorDeTaxa {

	/**
	 * @see CalculadorDeTaxa#calculaTaxaDa(Transferencia)
	 */
	public BigDecimal calculaTaxaDa(Transferencia transferencia) {
		DateTime inicio = new DateTime(transferencia.getCriacao()
				.getTimeInMillis());
		DateTime fim = new DateTime(transferencia.getData().getTimeInMillis());

		int dias = Days.daysBetween(inicio, fim).getDays();

		String taxa = null;

		if (dias > 30)
			taxa = "0.012";
		else if (dias > 25)
			taxa = "0.021";
		else if (dias > 20)
			taxa = "0.043";
		else if (dias > 15)
			taxa = "0.054";
		else if (dias > 10)
			taxa = "0.067";
		else if (dias > 5)
			taxa = "0.074";
		else
			taxa = "0.083";

		return transferencia.getValor().multiply(new BigDecimal(taxa));
	}

}
