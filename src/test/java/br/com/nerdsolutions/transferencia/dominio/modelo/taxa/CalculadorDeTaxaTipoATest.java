package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Testes de unidade de {@link CalculadorDeTaxaTipoA}.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoATest {

	@Test
	public void deveCalcularTaxa() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoA();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("5.000"))));
	}

}
