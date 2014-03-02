package br.com.nerdsolutions.transferencia.dominio.repositorio;

import java.util.List;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Repositório de transferências bancárias.
 * 
 * @author Newton Angelini
 * 
 */
public interface TodasTransferencias {

	/**
	 * Adiciona a transferência ao repositório.
	 * 
	 * @param transferencia
	 *            transferência que será adicionada ao repositório
	 */
	void adiciona(Transferencia transferencia);

	/**
	 * Lista todas as transferências bancárias do repositório.
	 * 
	 * @return todas as transferências bancárias do repositório
	 */
	List<Transferencia> listaTodas();

}
