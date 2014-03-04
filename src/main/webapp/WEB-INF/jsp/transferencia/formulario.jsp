<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/base.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Nerdsolutions | Agendar transferência</title>
</head>
<body>

	<h1>Agendar transferência</h1>

	<p>
		<a href="<c:url value="/transferencia/todas" />">Transferências agendadas</a> &gt; Agendar transferência 
	<p>

	<ul>
		<c:forEach items="${errors }" var="error">
			<li>${error.message }</li>
		</c:forEach>
	</ul>

	<form action="<c:url value="/transferencia/nova" />" method="POST">

		<label for="numero-origem" class="block-label">Conta de origem</label>
		<input id="numero-origem" type="number" name="dto.origem.numero" size="5" maxlength="5" value="${dto.origem.numero }" /> - 
		<input id="digito-verificador-origem" type="number" name="dto.origem.digitoVerificador" size="1" maxlength="1" value="${dto.origem.digitoVerificador }" />
		
		<label for="numero-destino" class="block-label">Conta de destino</label>
		<input id="numero-destino" type="number" name="dto.destino.numero" size="5" maxlength="5" value="${dto.destino.numero }" /> - 
		<input id="digito-verificador-destino" type="number" name="dto.destino.digitoVerificador" size="1" maxlength="1" value="${dto.destino.digitoVerificador }" />
		
		<label for="valor" class="block-label">Valor da transferência</label>
		<input id="valor" type="number" name="dto.valor" size="6" value="${dto.valor }" /> 
		
		<label for="data" class="block-label">Data da transferência</label>
		<input id="data" type="date" name="dto.data" value="<fmt:formatDate value="${dto.data.time }" pattern="yyyy-MM-dd" />" /> 
		
		<label class="block-label">Tipo da transferência</label>

		<input id="tipo-a" type="radio" name="dto.tipo" value="A" <c:if test="${dto.tipo == 'A' }">checked="checked"</c:if> />
		<label for="tipo-a">A - Operações do tipo A tem uma taxa de R$ 2,00 mais 3% do valor da trasferência.</label>

		<br />

		<input id="tipo-b" type="radio" name="dto.tipo" value="B" <c:if test="${dto.tipo == 'B' }">checked="checked"</c:if> />
		<label for="tipo-b">B - Operações do tipo B tem uma taxa de R$ 10,00 para pedidos com agendamento até 30 dias da data de cadastro e R$ 8,00 para os demais.</label>

		<br />

		<input id="tipo-c" type="radio" name="dto.tipo" value="C" <c:if test="${dto.tipo == 'C' }">checked="checked"</c:if> />
		<label for="tipo-c">C - Operações do tipo C tem uma taxa regressiva conforme a data de agendamento.</label>

		<br />

		<input id="tipo-d" type="radio" name="dto.tipo" value="D" <c:if test="${dto.tipo == 'D' }">checked="checked"</c:if> />
		<label for="tipo-d">D - Operações do tipo D tem a taxa igual a A, B ou C dependendo do valor da transferência.</label>
		
		<br />
		
		<button id="agendar-transferencia" type="submit">Agendar transferência</button>

	</form>

</body>
</html>