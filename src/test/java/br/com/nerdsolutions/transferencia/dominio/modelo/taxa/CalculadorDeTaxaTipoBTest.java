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
 * Testes de unidade de {@link CalculadorDeTaxaTipoB}.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoBTest {

	@Test
	public void deveCalcularTaxaParaTransferenciaAntesDe30Dias() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 29);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoB();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("10.0"))));
	}

	@Test
	public void deveCalcularTaxaParaTransferenciaDaqui30Dias() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 30);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoB();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("10.0"))));
	}

	@Test
	public void deveCalcularTaxaParaTransferenciaDepoisDe30Dias() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 31);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoB();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("8.0"))));
	}

}
