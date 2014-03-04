package br.com.nerdsolutions.transferencia.infraestrutura.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;
import br.com.nerdsolutions.transferencia.dominio.repositorio.TodasTransferencias;
import br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo.TransferenciaConverter;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * Data Access Object de {@link Transferencia}.
 * 
 * @author Newton Angelini
 * 
 */
@Component
public class TransferenciaDAO implements TodasTransferencias {

	private static final String COLLECTION = "transferencias";

	private final DB db;

	private final TransferenciaConverter converter;

	public TransferenciaDAO(DB db, TransferenciaConverter converter) {
		this.db = db;
		this.converter = converter;
	}

	/**
	 * @see TodasTransferencias#adiciona(Transferencia)
	 */
	public void adiciona(Transferencia transferencia) {
		DBCollection transferencias = db.getCollection(COLLECTION);

		BasicDBObject dbObject = converter.toDBObject(transferencia);

		transferencias.insert(dbObject);
	}

	/**
	 * @see TodasTransferencias#listaTodas()
	 */
	public List<Transferencia> listaTodas() {
		DBCollection transferencias = db.getCollection(COLLECTION);

		DBCursor cursor = transferencias.find();

		ArrayList<Transferencia> retorno = new ArrayList<Transferencia>();

		while (cursor.hasNext()) {
			BasicDBObject dbObject = new BasicDBObject(cursor.next().toMap());
			Transferencia transferencia = converter.fromDBObject(dbObject);
			retorno.add(transferencia);
		}

		return retorno;
	}

}
