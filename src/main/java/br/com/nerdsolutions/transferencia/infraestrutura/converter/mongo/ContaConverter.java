package br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;

import com.mongodb.BasicDBObject;

/**
 * Conversor de {@link Conta} do para {@link BasicDBObject} e vice-versa.
 * 
 * @author Newton Angelini
 * 
 */
@Component
public class ContaConverter implements DBObjectConverter<Conta> {

	/**
	 * @see DBObjectConverter#fromDBObject(BasicDBObject)
	 */
	public Conta fromDBObject(BasicDBObject dbObject) {
		return new Conta().comNumero(dbObject.getInt("numero"))
				.comDigitoVerificador(dbObject.getInt("digitoVerificador"));
	}

	/**
	 * @see DBObjectConverter#toDBObject(Object)
	 */
	public BasicDBObject toDBObject(Conta conta) {
		return new BasicDBObject("numero", conta.getNumero()).append(
				"digitoVerificador", conta.getDigitoVerificador());
	}

}
