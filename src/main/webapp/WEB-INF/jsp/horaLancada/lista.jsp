<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"/>

<a href="${linkTo[HoraLancadaController].form()}" >Cadastrar hora</a>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Td</th>
			<th>Data</th>
			<th>Hora Inicial</th>
			<th>Hora Final</th>
			<th>Dura��o</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${horas}" var="h" >
			<tr>
				<td>${h.id}</td>
				<td>${h.data.time}</td>
				<td>${h.horaInicial}</td>
				<td>${h.horaFinal}</td>
				<td>${h.duracao}</td>
			</tr>			
		</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp"/>