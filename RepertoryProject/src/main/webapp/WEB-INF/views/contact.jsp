<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		<div style="margin-top: 15px; width: 550px;" align="left">
			<div class="return_to_repertory" onClick="openLink('repertory')"><table height=28><tr><td><img src="resources/img/back.png" height=20 style="opacity: 0.7; filter: alpha(opacity=70);"></td><td><h4 style="margin: 0px; color: #39A1DB;">&nbsp;Retourner au répertoire</h4></td></tr></table></div>
		</div>
		<div id="search_result" style="margin-top: 0px;">
			<table>
				<tr>
					<td><img src="resources/img/contact.jpg" width=100
						style="margin-top: 10px;"></td>
					<td><br><h1>&nbsp;${contact.getPrenom()} ${contact.getNom()}</h1></td>
				</tr>
			</table>
			<br>
			<b>Email : </b> ${contact.getEmail()}<br> <b>Date de
				Naissance : </b> ${dateformat.format(contact.getDateNaissance())}<br>
			<b>Actif : </b> ${contact.getActif()}<br>
			<br>
			<b>Adresses : </b>
			<c:if test="${not empty contact.getAdresses()}">
				<c:forEach var="adresse" items="${contact.getAdresses()}">
					<li><b>${adresse.getIntitule()}</b> - ${adresse.toString()}</li>
				</c:forEach>
			</c:if>
			<c:if test="${empty contact.getAdresses()}">
				Aucune adresse enregistrée
			</c:if>
		</div>
	</center>
</body>
</html>