package br.com.nerdsolutions.transferencia.dominio.modelo;

/**
 * Enumera��o de tipos de transfer�ncias banc�rias.
 * 
 * @author Newton Angelini
 * 
 */
public enum Tipo {

	/**
	 * Opera��es do tipo A tem uma taxa de $2 mais 3% do valor da trasfer�ncia.
	 */
	A,

	/**
	 * Opera��es do tipo B tem uma taxa de $10 para pedidos com agendamento at�
	 * 30 dias da data de cadastro e $8 para os demais.
	 */
	B,

	/**
	 * Opera��es do tipo C tem uma taxa regressiva conforme a data de
	 * agendamento.
	 * 
	 * <ul>
	 * <li>maior que 30 dias da data de cadastro - 1.2%</li>
	 * <li>at� 30 dias da data de cadastro - 2.1%</li>
	 * <li>at� 25 dias da data de cadastro - 4.3%</li>
	 * <li>at� 20 dias da data de cadastro - 5.4%</li>
	 * <li>at� 15 dias da data de cadastro - 6.7%</li>
	 * <li>at� 10 dias da data de cadastro - 7.4%</li>
	 * <li>at� 5 dias da data de cadastro - 8.3%</li>
	 * </ul>
	 */
	C,

	/**
	 * Opera��es do tipo D tem a taxa igual a A, B ou C dependendo do valor da
	 * transfer�ncia.
	 * 
	 * <ul>
	 * <li>Valores at� $25.000 seguem a taxa��o tipo A</li>
	 * <li>Valores de $25.001 at� $120000 seguem a taxa��o tipo B</li>
	 * <li>Valores maiores que $120000 seguem a taxa��o tipo C</li>
	 * </ul>
	 */
	D;

}
