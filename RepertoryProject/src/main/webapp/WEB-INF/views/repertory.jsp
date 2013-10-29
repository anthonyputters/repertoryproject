<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<table id="hor-zebra" summary="Employee Pay Sheet">
		<thead>
			<tr>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">E-mail</th>
				<th scope="col">Date de Naissance</th>
				<th scope="col">Actif</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<c:if test="${not empty contacts}">
			<tbody>
				<%
					int i = 0;
				%>
				<c:forEach var="contact" items="${contacts}">
					<%
						if (i % 2 == 0) {
					%>
					<tr class="odd">
						<%
							} else {
						%>
					
					<tr>
						<%
							}
						%>
						<td>${contact.getNom()}</td>
						<td>${contact.getPrenom()}</td>
						<td>${contact.getEmail()}</td>
						<td>${dateformat.format(contact.getDateNaissance())}</td>
						<td>${contact.getActif()}</td>
						<td>

							<button
								onClick="javascript:openLink('repertory?action=modify&id=${contact.hashCode()}')"
								id="modify">Modifier</button> <br>

							<button
								onClick="javascript:openLink('repertory?action=remove&id=${contact.hashCode()}')"
								id="remove">Supprimer</button> <br>
						</td>
					</tr>
					<%
						i++;
					%>
				</c:forEach>
			</tbody>
		</c:if>
	</table>
</body>
</html>