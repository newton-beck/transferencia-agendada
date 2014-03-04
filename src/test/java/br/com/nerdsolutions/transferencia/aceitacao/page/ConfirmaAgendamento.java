package br.com.nerdsolutions.transferencia.aceitacao.page;

import org.openqa.selenium.WebDriver;

/**
 * Page Object da página de confirmação de agendamento de transferência
 * bancária.
 * 
 * @author Newton Angelini
 * 
 */
public class ConfirmaAgendamento {

	private final WebDriver driver;

	public ConfirmaAgendamento(WebDriver driver) {
		this.driver = driver;
	}

	public boolean temMensagem(String mensagem) {
		return driver.getPageSource().contains(mensagem);
	}

}
