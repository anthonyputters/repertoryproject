<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="stylized" class="addform">
	<form id="searchContactForm" name="searchContactForm" method="post" action="javascript:sendSearchFormData()">
		<h1>Rechercher</h1>
		<p>Cette page vous permet de rechercher un contact par Prénom et/ou Nom et/ou E-mail.</p>

		<table>
			<tr>
				<td><label> Prénom <span class="small"> Prénom
							du contact </span>
				</label></td>
				<td><input type="text" name="prenom" id="prenom"/></td>
			</tr>
			<tr>
				<td><label> Nom <span class="small"> Nom du
							contact </span>
				</label></td>
				<td><input type="text" name="nom" id="nom"/></td>
			</tr>
			<tr>
				<td><label> E-mail <span class="small"> Adresse
							e-mail </span>
				</label></td>
				<td><input type="email" name="email" id="email"/></td>
			</tr>
		</table>
		<br>
		<button type="submit">Rechercher</button>
	</form>
</div>

<div id="search_result">
	<h2>Résultats de la recherche</h2>
	<c:if test="${not empty contacts}">
		<% int i = 1; %>
		<c:forEach var="contact" items="${contacts}">
			<div class="result">
				<h3 class="link" onClick="javascript:openLink('contact?contactHashCode=${contact.hashCode()}')">&nbsp;${contact.getPrenom()} ${contact.getNom()}</h3>
				<b>Email : </b> ${contact.getEmail()}<br> 
				<b>Date de Naissance : </b> ${dateformat.format(contact.getDateNaissance())}<br>
				<b>Actif : </b> ${contact.getActif()}
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${empty contacts}">
		<c:if test="${nom != null}">
			Aucun résultats trouvés pour ces critères
		</c:if>

		<c:if test="${nom == null}">
			Vous n'avez pas encore lancé de recherche
		</c:if>

	</c:if>

</div>