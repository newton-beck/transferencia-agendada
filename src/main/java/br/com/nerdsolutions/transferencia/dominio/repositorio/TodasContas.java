package br.com.nerdsolutions.transferencia.dominio.repositorio;

import java.util.List;

import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;

/**
 * Reposit�rio de contas banc�rias.
 * 
 * @author Newton Angelini
 * 
 */
public interface TodasContas {

	/**
	 * Lista todas as contas banc�rias do reposit�rio.
	 * 
	 * @return todas as contas banc�rias do reposit�rio
	 */
	List<Conta> listaTodas();

}
