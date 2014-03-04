package br.com.nerdsolutions.transferencia.infraestrutura.dao;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;
import br.com.nerdsolutions.transferencia.dominio.repositorio.TodasContas;

/**
 * Data Access Object de {@link Conta}.
 * 
 * @author Newton Angelini
 * 
 */
@Component
public class ContaDAO implements TodasContas {

	public List<Conta> listaTodas() {
		return null;
	}

}
