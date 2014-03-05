<div class="jumbotron">
	<div class="container">
		<h1>Agendar transferência</h1>
	</div>
</div>

<ol class="breadcrumb">
	<li><a href="<c:url value="/transferencia/todas" />">Transferências
			agendadas</a></li>
	<li class="active">Agendar transferência</li>
</ol>

<div class="container">
	<c:if test="${not empty errors}">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h5>Erros de validação</h5>
			</div>
			<div class="panel-body">
				<ul>
					<c:forEach items="${errors }" var="error">
						<li>${error.message }</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>

	<form action="<c:url value="/transferencia/nova" />" method="POST">
	
		<div class="form-group">
			<label for="numero-origem">Conta de origem</label>
			<div class="row">
				<div class="col-xs-10 col-sm-11">
					<input id="numero-origem" class="form-control" type="number" name="dto.origem.numero" value="${dto.origem.numero }" />
				</div>
				<div class="col-xs-2 col-sm-1">
					<input id="digito-verificador-origem" class="form-control" type="number" name="dto.origem.digitoVerificador" value="${dto.origem.digitoVerificador }" />
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label for="numero-destino">Conta de destino</label>
			<div class="row">
				<div class="col-xs-10 col-sm-11">
					<input id="numero-destino" class="form-control" type="number" name="dto.destino.numero" value="${dto.destino.numero }" />
				</div>
				<div class="col-xs-2 col-sm-1">
					<input id="digito-verificador-destino" class="form-control" type="number" name="dto.destino.digitoVerificador" value="${dto.destino.digitoVerificador }" />
				</div>
			</div>
		</div>
		
		<div class="form-group">
			 <label for="valor">Valor</label> 
			<input id="valor" type="number" class="form-control" name="dto.valor" value="${dto.valor }" />
		</div>
		
		<div class="form-group">
			<label for="data">Data da transferência</label>
			<input id="data" type="date" class="form-control" name="dto.data" value="<fmt:formatDate value="${dto.data.time }" pattern="yyyy-MM-dd" />" />
		</div>

		<div class="form-group">
			<label class="block-label">Tipo</label>

			<div class="radio">
				<label>
					<input id="tipo-a" type="radio" name="dto.tipo" value="A" <c:if test="${dto.tipo == 'A' }">checked="checked"</c:if> />
					A - Operações do tipo A tem uma taxa de R$ 2,00 mais 3% do valor da trasferência.
				</label>
			</div>
			
			<div class="radio">
				<label>
					<input id="tipo-b" type="radio" name="dto.tipo" value="B" <c:if test="${dto.tipo == 'B' }">checked="checked"</c:if> />
					B - Operações do tipo B tem uma taxa de R$ 10,00 para pedidos com agendamento até 30 dias da data de cadastro e R$ 8,00 para os demais.
				</label>
			</div>
			
			<div class="radio">
				<label>
					<input id="tipo-c" type="radio" name="dto.tipo" value="C" <c:if test="${dto.tipo == 'C' }">checked="checked"</c:if> />
					C - Operações do tipo C tem uma taxa regressiva conforme a data de agendamento.
				</label>
			</div>
			
			<div class="radio">
				<label>
					<input id="tipo-d" type="radio" name="dto.tipo" value="D" <c:if test="${dto.tipo == 'D' }">checked="checked"</c:if> />
					D - Operações do tipo D tem a taxa igual a A, B ou C dependendo do valor da transferência.
				</label>
			</div>
			
		</div>
	
		<button id="agendar-transferencia" class="btn btn-primary btn-lg pull-right" type="submit">
			<span class="glyphicon glyphicon-calendar"></span>
			Agendar transferência
		</button>
	
	</form>

</div>