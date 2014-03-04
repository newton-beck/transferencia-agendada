package br.com.nerdsolutions.transferencia.aceitacao.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.nerdsolutions.transferencia.dominio.modelo.Tipo;

/**
 * Page Object do agendamento de transferências bancárias.
 * 
 * @author Newton Angelini
 * 
 */
public class AgendaTransferencia {

	private final WebDriver driver;

	public AgendaTransferencia(WebDriver driver) {
		this.driver = driver;
	}

	public AgendaTransferencia acessa() {
		driver.get("http://localhost:8080/transferencia-agendada/transferencia/nova");
		return this;
	}

	public ConfirmaAgendamento agendaTransferencia() {
		driver.findElement(By.id("agendar-transferencia")).click();

		return new ConfirmaAgendamento(driver);
	}

	public AgendaTransferencia comContaDeDestino(Integer numero,
			Integer digitoVerificador) {
		driver.findElement(By.id("numero-destino")).sendKeys(numero.toString());
		driver.findElement(By.id("digito-verificador-destino")).sendKeys(
				digitoVerificador.toString());
		return this;
	}

	public AgendaTransferencia comContaDeOrigem(Integer numero,
			Integer digitoVerificador) {
		driver.findElement(By.id("numero-origem")).sendKeys(numero.toString());
		driver.findElement(By.id("digito-verificador-origem")).sendKeys(
				digitoVerificador.toString());
		return this;
	}

	public AgendaTransferencia comData(Integer dia, Integer mes, Integer ano) {
		driver.findElement(By.id("data")).sendKeys(
				ano.toString() + "-" + mes.toString() + "-" + dia.toString());
		return this;
	}

	public AgendaTransferencia comValor(Double valor) {
		driver.findElement(By.id("valor")).sendKeys(valor.toString());
		return this;
	}

	public AgendaTransferencia doTipo(Tipo tipo) {
		driver.findElement(By.id("tipo-" + tipo.toString().toLowerCase()))
				.click();
		return this;
	}

	public boolean temErro(String erro) {
		return driver.getPageSource().contains(erro);
	}

}
