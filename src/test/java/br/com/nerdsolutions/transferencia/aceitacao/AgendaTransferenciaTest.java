package br.com.nerdsolutions.transferencia.aceitacao;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nerdsolutions.transferencia.aceitacao.page.AgendaTransferencia;
import br.com.nerdsolutions.transferencia.dominio.modelo.Tipo;

/**
 * Testes de aceita��o do agendamento de transfer�ncias banc�rias.
 * 
 * @author Newton Angelini
 * 
 */
public class AgendaTransferenciaTest {

	private WebDriver driver;

	@Before
	public void antes() {
		this.driver = new FirefoxDriver();
	}

	@After
	public void depois() {
		this.driver.close();
	}

	@Test
	public void naoDeveAgendarUmaTarefaInvalida() {
		AgendaTransferencia pagina = new AgendaTransferencia(driver);
		
		pagina.acessa().agendaTransferencia();
		
		assertTrue(pagina.temErro("O n�mero da conta de origem � obrigat�rio."));
		assertTrue(pagina.temErro("O d�gito verificador da conta de origem � obrigat�rio."));
		assertTrue(pagina.temErro("O n�mero da conta de destino � obrigat�rio."));
		assertTrue(pagina.temErro("O d�gito verificador da conta de destino � obrigat�rio."));
		assertTrue(pagina.temErro("O valor da transfer�ncia � obrigat�rio e deve ser maior que zero."));
		assertTrue(pagina.temErro("A data da transfer�ncia � obrigat�ria e deve ser uma data futura."));
		assertTrue(pagina.temErro("O tipo da transfer�ncia � obrigat�rio."));
	}

	@Test
	public void deveAgendarUmaTarefaValida() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DATE, 10);

		AgendaTransferencia pagina = new AgendaTransferencia(driver);

		pagina.acessa()
				.comContaDeDestino(12345, 1)
				.comContaDeOrigem(56789, 0)
				.comValor(550.00)
				.comData(data.get(Calendar.DATE), data.get(Calendar.MONTH) + 1,
						data.get(Calendar.YEAR)).doTipo(Tipo.A)
				.agendaTransferencia();
		
		// TODO Verificar o resultado do agendamento
	}
}
