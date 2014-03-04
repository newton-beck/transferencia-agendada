package br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo;

import com.mongodb.BasicDBObject;

/**
 * Conversor de {@link BasicDBObject} do MongoDB para entidades de domínio e
 * vice-versa.
 * 
 * @author Newton Angelini
 * 
 * @param <T>
 *            tipo da entidade de domínio que será convertido
 */
public interface DBObjectConverter<T> {

	/**
	 * Converte o {@link BasicDBObject} do MongoDB em entidade de domínio.
	 * 
	 * @param dbObject
	 *            {@link BasicDBObject} do MongoDB
	 * @return entidade de domínio
	 */
	public T fromDBObject(BasicDBObject dbObject);

	/**
	 * Converte a entidade do domínio em um {@link BasicDBObject} do MongoDB.
	 * 
	 * @param t
	 *            entidade de domínio
	 * @return {@link BasicDBObject}
	 */
	public BasicDBObject toDBObject(T t);

}
