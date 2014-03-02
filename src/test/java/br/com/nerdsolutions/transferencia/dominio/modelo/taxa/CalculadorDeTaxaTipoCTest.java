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
 * Testes de unidade para {@link CalculadorDeTaxaTipoC}.
 * 
 * @author Newton Angelini
 * 
 */
public class CalculadorDeTaxaTipoCTest {

	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMaiorQue30Dias() {
		Calendar criacao = Calendar.getInstance();
		
		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 31);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("1.2000"))));
	}

	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMenorOuIgualQue30Dias() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 30);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(Calendar.getInstance());
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("2.1000"))));
	}
	
	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMenorOuIgualQue25Dias() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 25);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(Calendar.getInstance());
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("4.3000"))));
	}
	
	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMenorOuIgualQue20Dias() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 20);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(Calendar.getInstance());
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("5.4000"))));
	}
	
	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMenorOuIgualQue15Dias() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 15);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(Calendar.getInstance());
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("6.7000"))));
	}
	
	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMenorOuIgualQue10Dias() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 10);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(Calendar.getInstance());
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("7.4000"))));
	}
	
	@Test
	public void deveCalcularTaxaDaTransferenciaComDataMenorOuIgualQue5Dias() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 5);

		Transferencia transferencia = mock(Transferencia.class);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getCriacao()).thenReturn(Calendar.getInstance());
		when(transferencia.getData()).thenReturn(data);

		CalculadorDeTaxa calculador = new CalculadorDeTaxaTipoC();

		BigDecimal taxa = calculador.calculaTaxaDa(transferencia);

		assertThat(taxa, is(equalTo(new BigDecimal("8.3000"))));
	}

}
