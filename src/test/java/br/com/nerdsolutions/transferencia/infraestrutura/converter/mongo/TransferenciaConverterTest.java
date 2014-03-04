package br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;
import br.com.nerdsolutions.transferencia.dominio.modelo.Tipo;
import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

import com.mongodb.BasicDBObject;

/**
 * Testes de unidade de {@link TransferenciaConverter}.
 * 
 * @author Newton Angelini
 * 
 */
public class TransferenciaConverterTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	Transferencia transferencia;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	ContaConverter contaConverter;

	@Mock
	Conta conta;

	TransferenciaConverter transferenciaConverter;

	@Before
	public void antes() {
		MockitoAnnotations.initMocks(this);

		transferenciaConverter = new TransferenciaConverter(contaConverter);
	}

	@Test
	public void deveConverterUmaTransferenciaParaDBObject() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 10);

		when(transferencia.getOrigem()).thenReturn(conta);
		when(transferencia.getDestino()).thenReturn(conta);
		when(transferencia.getCriacao()).thenReturn(criacao);
		when(transferencia.getData()).thenReturn(data);
		when(transferencia.getValor()).thenReturn(new BigDecimal("100.0"));
		when(transferencia.getTipo()).thenReturn(Tipo.A);
		when(transferencia.getTaxa()).thenReturn(new BigDecimal("5.0"));

		when(contaConverter.toDBObject(any(Conta.class))).thenReturn(
				new BasicDBObject("numero", 12345).append("digitoVerificador",
						6));

		BasicDBObject dbObject = transferenciaConverter
				.toDBObject(transferencia);

		BasicDBObject dbObjectConta = new BasicDBObject("numero", 12345)
				.append("digitoVerificador", 6);

		BasicDBObject dbObjectTransferencia = new BasicDBObject("origem",
				dbObjectConta).append("destino", dbObjectConta)
				.append("criacao", criacao.getTime())
				.append("data", data.getTime()).append("valor", 100.0)
				.append("tipo", "A").append("taxa", 5.0);

		assertEquals(dbObjectTransferencia, dbObject);
	}

	@Test
	public void deveConverterUmDBObjectParaTransferencia() {
		Calendar criacao = Calendar.getInstance();

		Calendar data = (Calendar) criacao.clone();
		data.add(Calendar.DATE, 10);

		BasicDBObject dbObject = new BasicDBObject("criacao", criacao.getTime())
				.append("data", data.getTime()).append("valor", 100.0)
				.append("tipo", "A").append("taxa", 5.0);

		Conta conta = new Conta().comNumero(12345).comDigitoVerificador(6);

		when(contaConverter.fromDBObject(any(BasicDBObject.class))).thenReturn(
				conta);

		Transferencia transferencia = transferenciaConverter
				.fromDBObject(dbObject);

		Transferencia transferenciaEsperada = new Transferencia(criacao)
				.de(conta).para(conta).comValor(new BigDecimal(100.0))
				.naData(data).doTipo(Tipo.A).cria();

		assertEquals(transferenciaEsperada, transferencia);
	}

}
