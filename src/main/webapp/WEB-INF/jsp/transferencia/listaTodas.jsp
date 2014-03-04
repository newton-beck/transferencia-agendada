<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/base.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Nerdsolutions | Transfer�ncias agendadas</title>
</head>
<body>

	<h1>Transfer�ncias agendadas</h1>

	<a href="<c:url value="/transferencia/nova" />">Agendar transfer�ncia</a>

	<table>
		<thead>
			<tr>
				<th>Conta de origem</th>
				<th>Conta de destino</th>
				<th>Data do agendamento</th>
				<th>Data da transfer�ncia</th>
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

</body>
</html>