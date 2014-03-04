package br.com.nerdsolutions.transferencia.infraestrutura.factory;

import javax.annotation.PostConstruct;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Component Factory de {@link DB}.
 * 
 * @author Newton Angelini
 * 
 */
@Component
public class DBFactory implements ComponentFactory<DB> {

	private static final String DB = "transferencia-bancaria";
	
	private final MongoClient client;

	private DB db;

	public DBFactory(MongoClient client) {
		this.client = client;
	}

	/**
	 * @see ComponentFactory#getInstance()
	 */
	public DB getInstance() {
		return db;
	}

	@PostConstruct
	public void postConstruct() {
		db = client.getDB(DB);

		String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");

		db.authenticate(user, password.toCharArray());
	}

}
