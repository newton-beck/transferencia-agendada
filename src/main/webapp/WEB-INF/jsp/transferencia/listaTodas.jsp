<h1>Transferências agendadas</h1>

<a href="<c:url value="/transferencia/nova" />">Agendar transferência</a>

<table>
	<thead>
		<tr>
			<th>Conta de origem</th>
			<th>Conta de destino</th>
			<th>Data do agendamento</th>
			<th>Data da transferência</th>
			<th>Valor</th>
			<th>Taxa</th>
			<th>Tipo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${transferenciaList }" var="transferencia">
			<tr>
				<td>${transferencia.origem.numeroFormatado }</td>
				<td>${transferencia.destino.numeroFormatado }</td>
				<td><fmt:formatDate value="${transferencia.criacao.time }" pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatDate value="${transferencia.data.time }" pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatNumber value="${transferencia.valor }" type="currency" /></td>
				<td><fmt:formatNumber value="${transferencia.taxa }" type="currency" /></td>
				<td>${transferencia.tipo }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
