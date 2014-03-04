package br.com.nerdsolutions.transferencia.infraestrutura.factory;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Component Factory de {@link MongoClient}.
 * 
 * @author Newton Angelini
 * 
 */
@Component
@ApplicationScoped
public class MongoClientFactory implements ComponentFactory<MongoClient> {

	private MongoClient client;

	/**
	 * @see ComponentFactory#getInstance()
	 */
	public MongoClient getInstance() {
		return client;
	}

	@PostConstruct
	public void postConstruct() throws UnknownHostException {
		String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
		int port = Integer.parseInt(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));

		client = new MongoClient(new ServerAddress(host, port));
	}

	@PreDestroy
	public void preDestroy() {
		client.close();
	}
}
