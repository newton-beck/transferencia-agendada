package br.com.nerdsolutions.transferencia.dominio.modelo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 * Testes unidade para {@link Conta}.
 * 
 * @author Newton Angelini
 * 
 */
public class ContaTest {

	@Test
	public void deveCriarUmaContaAtravesDoBuilder() {
		Conta conta = new Conta().comNumero(12345).comDigitoVerificador(6);

		assertThat(conta.getNumeroFormatado(), is(equalTo("12345-6")));
	}

}
