package br.com.nerdsolutions.transferencia.dominio.modelo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

/**
 * Testes de unidade de {@link Transferencia}.
 * 
 * @author Newton Angelini
 * 
 */
public class TransferenciaTest {

	@Test
	public void deveCriarTransferenciaAtravesDoBuilder() {
		Conta origem = mock(Conta.class);
		Conta destino = mock(Conta.class);
		BigDecimal valor = new BigDecimal("120.55");
		Calendar data = Calendar.getInstance();

		Transferencia transferencia = new Transferencia().de(origem)
				.para(destino).comValor(valor).doTipo(Tipo.A).naData(data)
				.cria();

		assertThat(transferencia.getOrigem(), is(equalTo(origem)));
		assertThat(transferencia.getDestino(), is(equalTo(destino)));
		assertThat(transferencia.getValor(), is(equalTo(valor)));
		assertThat(transferencia.getTaxa(), is(not(nullValue())));
		assertThat(transferencia.getData(), is(equalTo(data)));
		assertThat(transferencia.getTipo(), is(equalTo(Tipo.A)));
	}
}
