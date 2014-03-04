package br.com.nerdsolutions.transferencia.infraestrutura.dao;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;
import br.com.nerdsolutions.transferencia.dominio.repositorio.TodasTransferencias;

/**
 * Data Access Object de {@link Transferencia}.
 * 
 * @author Newton Angelini
 * 
 */
@Component
public class TransferenciaDAO implements TodasTransferencias {

	/**
	 * @see TodasTransferencias#adiciona(Transferencia)
	 */
	public void adiciona(Transferencia transferencia) {

	}

	/**
	 * @see TodasTransferencias#listaTodas()
	 */
	public List<Transferencia> listaTodas() {
		return null;
	}

}
