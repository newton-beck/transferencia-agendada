package br.com.nerdsolutions.transferencia.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;
import br.com.nerdsolutions.transferencia.dominio.modelo.Tipo;
import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;
import br.com.nerdsolutions.transferencia.dominio.repositorio.TodasTransferencias;
import br.com.nerdsolutions.transferencia.infraestrutura.dto.TransferenciaDTO;

/**
 * Testes de unidade para {@link TransferenciaController}.
 * 
 * @author Newton Angelini
 * 
 */
public class TransferenciaControllerTest {

	MockValidator validator;

	MockResult result;

	@Mock
	TodasTransferencias todasTransferencias;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	TransferenciaDTO transferencia;

	@Before
	public void antes() {
		MockitoAnnotations.initMocks(this);

		this.validator = new MockValidator();
		this.result = new MockResult();
	}

	@Test(expected = ValidationException.class)
	public void naoDeveAdicionarUmTransferenciaInvalida() {
		TransferenciaController controller = new TransferenciaController(
				this.validator, this.result, this.todasTransferencias);

		controller.adiciona(this.transferencia);
	}

	@Test
	public void deveAdicionarUmaTransferenciaValida() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 10);

		when(this.transferencia.getOrigem().getNumero()).thenReturn(12345);
		when(this.transferencia.getOrigem().getDigitoVerificador()).thenReturn(
				6);
		when(this.transferencia.getDestino().getNumero()).thenReturn(67890);
		when(this.transferencia.getDestino().getDigitoVerificador())
				.thenReturn(1);
		when(this.transferencia.getData()).thenReturn(data);
		when(this.transferencia.getValor()).thenReturn(200.0);
		when(this.transferencia.getTipo()).thenReturn(Tipo.A);

		TransferenciaController controller = new TransferenciaController(
				this.validator, this.result, this.todasTransferencias);

		controller.adiciona(this.transferencia);

		Transferencia transferenciaEsperada = new Transferencia()
				.de(new Conta().comNumero(12345).comDigitoVerificador(6))
				.para(new Conta().comNumero(67890).comDigitoVerificador(1))
				.comValor(new BigDecimal(200.0)).naData(data).doTipo(Tipo.A)
				.cria();

		verify(this.todasTransferencias, times(1)).adiciona(
				transferenciaEsperada);
	}
}
