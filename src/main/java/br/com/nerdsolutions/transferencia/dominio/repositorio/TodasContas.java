package br.com.nerdsolutions.transferencia.dominio.repositorio;

import java.util.List;

import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;

/**
 * Repositório de contas bancárias.
 * 
 * @author Newton Angelini
 * 
 */
public interface TodasContas {

	/**
	 * Lista todas as contas bancárias do repositório.
	 * 
	 * @return todas as contas bancárias do repositório
	 */
	List<Conta> listaTodas();

}
