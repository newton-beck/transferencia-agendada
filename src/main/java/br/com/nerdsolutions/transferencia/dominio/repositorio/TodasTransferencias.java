package br.com.nerdsolutions.transferencia.dominio.repositorio;

import java.util.List;

import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

/**
 * Reposit�rio de transfer�ncias banc�rias.
 * 
 * @author Newton Angelini
 * 
 */
public interface TodasTransferencias {

	/**
	 * Adiciona a transfer�ncia ao reposit�rio.
	 * 
	 * @param transferencia
	 *            transfer�ncia que ser� adicionada ao reposit�rio
	 */
	void adiciona(Transferencia transferencia);

	/**
	 * Lista todas as transfer�ncias banc�rias do reposit�rio.
	 * 
	 * @return todas as transfer�ncias banc�rias do reposit�rio
	 */
	List<Transferencia> listaTodas();

}
