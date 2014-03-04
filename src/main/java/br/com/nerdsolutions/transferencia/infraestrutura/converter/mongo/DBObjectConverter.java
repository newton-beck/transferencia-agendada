package br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo;

import com.mongodb.BasicDBObject;

/**
 * Conversor de {@link BasicDBObject} do MongoDB para entidades de dom�nio e
 * vice-versa.
 * 
 * @author Newton Angelini
 * 
 * @param <T>
 *            tipo da entidade de dom�nio que ser� convertido
 */
public interface DBObjectConverter<T> {

	/**
	 * Converte o {@link BasicDBObject} do MongoDB em entidade de dom�nio.
	 * 
	 * @param dbObject
	 *            {@link BasicDBObject} do MongoDB
	 * @return entidade de dom�nio
	 */
	public T fromDBObject(BasicDBObject dbObject);

	/**
	 * Converte a entidade do dom�nio em um {@link BasicDBObject} do MongoDB.
	 * 
	 * @param t
	 *            entidade de dom�nio
	 * @return {@link BasicDBObject}
	 */
	public BasicDBObject toDBObject(T t);

}
