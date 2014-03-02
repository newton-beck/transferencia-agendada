package br.com.nerdsolutions.transferencia.dominio.modelo.taxa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Testes de unidade para {@link CalculadorDeTaxaTipoD}.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoDTest {

	@Test
	public void deveCalcularTaxaParaValoresMaioresQue120000() {
		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("120001"));

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoD();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("3602.03"))));
	}

	@Test
	public void deveCalcularTaxaParaValoresMaioresQue25000() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 30);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("25001"));
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoD();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("10.0"))));
	}

	@Test
	public void deveCalcularTaxaParaValoresMenoresOuIguaisQue25000() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 31);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("24999"));
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoD();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("299.988"))));
	}

}
