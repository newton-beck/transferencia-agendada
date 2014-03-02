package br.com.nerdsolutions.transferencia.dominio.modelo;

import java.math.BigDecimal;

import br.com.nerdsolutions.transferencia.dominio.modelo.taxa.CalculadorDeTaxa;
import br.com.nerdsolutions.transferencia.dominio.modelo.taxa.CalculadorDeTaxaTipoA;
import br.com.nerdsolutions.transferencia.dominio.modelo.taxa.CalculadorDeTaxaTipoB;
import br.com.nerdsolutions.transferencia.dominio.modelo.taxa.CalculadorDeTaxaTipoC;
import br.com.nerdsolutions.transferencia.dominio.modelo.taxa.CalculadorDeTaxaTipoD;

/**
 * Enumeração de tipos de transferências bancárias.
 * 
 * @author Newton Angelini
 * 
 */
public enum Tipo {

	/**
	 * Operações do tipo A tem uma taxa de $2 mais 3% do valor da trasferência.
	 */
	A(new CalculadorDeTaxaTipoA()),

	/**
	 * Operações do tipo B tem uma taxa de $10 para pedidos com agendamento até
	 * 30 dias da data de cadastro e $8 para os demais.
	 */
	B(new CalculadorDeTaxaTipoB()),

	/**
	 * Operações do tipo C tem uma taxa regressiva conforme a data de
	 * agendamento.
	 * 
	 * <ul>
	 * <li>maior que 30 dias da data de cadastro - 1.2%</li>
	 * <li>até 30 dias da data de cadastro - 2.1%</li>
	 * <li>até 25 dias da data de cadastro - 4.3%</li>
	 * <li>até 20 dias da data de cadastro - 5.4%</li>
	 * <li>até 15 dias da data de cadastro - 6.7%</li>
	 * <li>até 10 dias da data de cadastro - 7.4%</li>
	 * <li>até 5 dias da data de cadastro - 8.3%</li>
	 * </ul>
	 */
	C(new CalculadorDeTaxaTipoC()),

	/**
	 * Operações do tipo D tem a taxa igual a A, B ou C dependendo do valor da
	 * transferência.
	 * 
	 * <ul>
	 * <li>Valores até $25.000 seguem a taxação tipo A</li>
	 * <li>Valores de $25.001 até $120000 seguem a taxação tipo B</li>
	 * <li>Valores maiores que $120000 seguem a taxação tipo C</li>
	 * </ul>
	 */
	D(new CalculadorDeTaxaTipoD());

	/**
	 * Calculador de taxa da transferência.
	 */
	private final CalculadorDeTaxa taxa;

	/**
	 * Cria uma enum de taxa.
	 * 
	 * @param taxa
	 */
	private Tipo(CalculadorDeTaxa taxa) {
		this.taxa = taxa;
	}

	/**
	 * Calcula o valor da taxa da tranferência bancária informada.
	 * 
	 * @param transferencia
	 *            transferência bancária
	 * @return valor da taxa da transferência bancária
	 */
	public BigDecimal calculaTaxaDa(Transferencia transferencia) {
		return this.taxa.calculaTaxaDa(transferencia);
	}

}