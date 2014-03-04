package br.com.nerdsolutions.transferencia.infraestrutura.converter.mongo;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.vraptor.ioc.Component;
import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;
import br.com.nerdsolutions.transferencia.dominio.modelo.Tipo;
import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;

import com.mongodb.BasicDBObject;

/**
 * Conversor de {@link Transferencia} para {@link BasicDBObject} do MongoDB e
 * vice-versa.
 * 
 * @author Newton Angelini
 * 
 */
@Component
public class TransferenciaConverter implements DBObjectConverter<Transferencia> {

	private final ContaConverter contaConverter;

	public TransferenciaConverter(ContaConverter contaConverter) {
		this.contaConverter = contaConverter;
	}

	/**
	 * @see DBObjectConverter#fromDBObject(BasicDBObject)
	 */
	public Transferencia fromDBObject(BasicDBObject dbObject) {
		Calendar criacao = Calendar.getInstance();
		criacao.setTime(dbObject.getDate("criacao"));

		Conta origem = contaConverter.fromDBObject((BasicDBObject) dbObject
				.get("origem"));

		Conta destino = contaConverter.fromDBObject((BasicDBObject) dbObject
				.get("destino"));

		Calendar data = Calendar.getInstance();
		data.setTime(dbObject.getDate("data"));

		Tipo tipo = Tipo.valueOf(dbObject.getString("tipo"));

		BigDecimal valor = new BigDecimal(dbObject.getDouble("valor"));

		return new Transferencia(criacao).de(origem).para(destino).comValor(valor)
				.naData(data).doTipo(tipo).cria();
	}

	/**
	 * @see DBObjectConverter#toDBObject(Object)
	 */
	public BasicDBObject toDBObject(Transferencia transferencia) {
		return new BasicDBObject()
				.append("origem",
						contaConverter.toDBObject(transferencia.getOrigem()))
				.append("destino",
						contaConverter.toDBObject(transferencia.getDestino()))
				.append("valor", transferencia.getValor().doubleValue())
				.append("taxa", transferencia.getTaxa().doubleValue())
				.append("data", transferencia.getData().getTime())
				.append("criacao", transferencia.getCriacao().getTime())
				.append("tipo", transferencia.getTipo().toString());
	}

}
