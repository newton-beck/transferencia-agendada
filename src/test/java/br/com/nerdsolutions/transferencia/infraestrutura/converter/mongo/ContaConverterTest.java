package br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Testes de unidade de {@link ContaConverter}.
 * 
 * @author Newton Angelini
 * 
 */
public class ContaConverterTest {

	@Mock
	Conta conta;

	@Mock
	BasicDBObject dbObject;

	ContaConverter converter;

	@Before
	public void antes() {
		MockitoAnnotations.initMocks(this);
		converter = new ContaConverter();
	}

	@Test
	public void deveConverterUmaContaEmDBObject() {
		when(conta.getNumero()).thenReturn(12345);
		when(conta.getDigitoVerificador()).thenReturn(6);

		DBObject dbObject = converter.toDBObject(conta);

		assertThat(dbObject.containsField("numero"), is(true));
		assertThat(dbObject.containsField("digitoVerificador"), is(true));
		assertThat(((Integer) dbObject.get("numero")), is(equalTo(12345)));
		assertThat(((Integer) dbObject.get("digitoVerificador")),
				is(equalTo(6)));
	}

	@Test
	public void deveConverterUmDBObjectEmConta() {
		when(dbObject.getInt("numero")).thenReturn(12345);
		when(dbObject.getInt("digitoVerificador")).thenReturn(6);

		Conta conta = converter.fromDBObject(dbObject);

		assertThat(conta.getNumero(), is(equalTo(12345)));
		assertThat(conta.getDigitoVerificador(), is(equalTo(6)));
	}

}
