package br.com.nerdsolutions.transferencia.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.nerdsolutions.transferencia.dominio.modelo.Conta;
import br.com.nerdsolutions.transferencia.dominio.modelo.Transferencia;
import br.com.nerdsolutions.transferencia.dominio.repositorio.TodasTransferencias;
import br.com.nerdsolutions.transferencia.infraestrutura.dto.TransferenciaDTO;

/**
 * Controlador de {@link Transferencia}.
 * 
 * @author Newton Angelini
 * 
 */
@Resource
@Path("/transferencia")
public class TransferenciaController {

	private final Validator validator;

	private final Result result;

	private final TodasTransferencias todasTransferencias;

	public TransferenciaController(Validator validator, Result result,
			TodasTransferencias todasTransferencias) {
		this.validator = validator;
		this.result = result;
		this.todasTransferencias = todasTransferencias;
	}

	@Get
	@Path("/nova")
	public void adiciona() {

	}

	@Post
	@Path("/nova")
	public void adiciona(TransferenciaDTO dto) {
		valida(dto);

		this.validator.onErrorForwardTo(this).adiciona();

		Conta origem = new Conta().comNumero(dto.getOrigem().getNumero())
				.comDigitoVerificador(dto.getOrigem().getDigitoVerificador());

		Conta destino = new Conta().comNumero(dto.getDestino().getNumero())
				.comDigitoVerificador(dto.getDestino().getDigitoVerificador());

		Transferencia transferencia = new Transferencia().de(origem)
				.para(destino).comValor(new BigDecimal(dto.getValor()))
				.naData(dto.getData()).doTipo(dto.getTipo()).cria();

		this.todasTransferencias.adiciona(transferencia);

		this.result.forwardTo(this).listaTodas();
	}

	@Get
	@Path("/todas")
	public List<Transferencia> listaTodas() {
		return this.todasTransferencias.listaTodas();
	}

	private void valida(final TransferenciaDTO transferencia) {
		this.validator.checking(new Validations() {
			{
				that(transferencia.getOrigem().getNumero() != null,
						"transferencia.origem.numero",
						"transferencia.conta_origem.numero.obrigatorio");
				that(transferencia.getOrigem().getDigitoVerificador() != null,
						"transferencia.origem.digitoVerificador",
						"transferencia.conta_origem.digito_verificador.obrigatorio");
				that(transferencia.getDestino().getNumero() != null,
						"transferencia.destino.numero",
						"transferencia.conta_destino.numero.obrigatorio");
				that(transferencia.getDestino().getDigitoVerificador() != null,
						"transferencia.destino.numero",
						"transferencia.conta_destino.digito_verificador.obrigatorio");
				that(transferencia.getValor() != null
						&& transferencia.getValor() > 0, "transferencia.valor",
						"transferencia.valor.obrigatorio");
				that(transferencia.getData() != null
						&& transferencia.getData().getTime().after(new Date()),
						"transferencia.data", "transferencia.data.obrigatorio");
				that(transferencia.getTipo() != null, "transferencia.tipo",
						"transferencia.tipo.obrigatorio");
			}
		});
	}

}
