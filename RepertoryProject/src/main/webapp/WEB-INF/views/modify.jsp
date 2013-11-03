<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.Date, fr.esiea.repertoryproject.metier.model.Contact, java.util.Calendar"%>

<center>
	<div style="margin-top: 20px; width: 560px;" align="left">
		<div class="return_to_repertory" onClick="openLink('repertory')">
			<table height=28>
				<tr>
					<td><img src="resources/img/back.png" height=20
						style="opacity: 0.7; filter: alpha(opacity = 70);"></td>
					<td><h4 style="margin: 0px; color: #39A1DB;">&nbsp;Retourner
							au répertoire</h4></td>
				</tr>
			</table>
		</div>
	</div>
</center>

<div id="stylized" class="addform"
	style="margin-top: 0px;">
	<form id="form" name="form" method="post" action="modifycontact">
		<h1>Modifier un contact</h1>
		<p>Cette page vous permet de modifier les informations relatives à
			un contact</p>

		<input type="hidden" name="contactHashCode" id="contactHashCode"
			value="${contact.hashCode()}" />

		<table>
			<tr>
				<td><label> Prénom <span class="small"> Prénom
							du contact </span>
				</label></td>
				<td><input type="text" name="prenom" id="prenom"
					required="required" value="${contact.getPrenom()}" /></td>
			</tr>
			<tr>
				<td><label> Nom <span class="small"> Nom du
							contact </span>
				</label></td>
				<td><input type="text" name="nom" id="nom" required="required"
					value="${contact.getNom()}" /></td>
			</tr>
			<tr>
				<td><label> E-mail <span class="small"> Adresse
							e-mail </span>
				</label></td>
				<td><input type="email" name="email" id="email"
					required="required" value="${contact.getEmail()}" /></td>
			</tr>
			<tr>
				<td><label> Date de Naissance <span class="small">
							Du nouveau contact </span>
				</label></td>
				<td><input type="date" name="dateNaissance" id="dateNaissance"
					required="required"
					value="${dateformat.format(contact.getDateNaissance())}" /></td>
			</tr>
			<tr>
				<td><label> Actif <span class="small"> Le
							contact est-il actif </span>
				</label></td>
				<td><input type="checkbox" name="actif" id="actif"
					value="${contact.getActif()}" /></td>
			</tr>
		</table>
		<br>
		<div id="addresses">
			<b>Adresses enregistrées :</b>
			<c:if test="${not empty contact.getAdresses()}">
				<c:forEach var="adresse" items="${contact.getAdresses()}">
					<li><b>${adresse.getIntitule()}</b> - ${adresse.toString()} <a
						href="javascript:openLink('removeaddress?contactHashCode=${contact.hashCode()}&addressHashCode=${adresse.hashCode()}')">Supprimer</a></li>
				</c:forEach>
			</c:if>
		</div>
		<a href="javascript:showAddAddressForm()">Ajouter une adresse au
			contact</a> <br> <br>

		<button type="submit" style="width: 270px">Enregistrer les
			modifications</button>

		<div class="spacer"></div>
	</form>
	<form id="addAddressForm" name="addAddressForm" method="get"
		action="javascript:addAddressModifyForm()">
		<p>&nbsp;</p>

		<h3>Ajouter une adresse au contact</h3>

		<input type="hidden" name="contactHashCode" id="contactHashCode"
			value="${contact.hashCode()}" /> <input type="hidden"
			name="addressHashCode" id="addressHashCode" />

		<table>
			<tr>
				<td><label> Intiltulé de l'Adresse <span class="small">
							Maison, Bureau etc. </span></label></td>
				<td><input type="text" name="intitule" id="intitule"
					required="required" /></td>
			</tr>
			<tr>
				<td><label> Numéro de rue</label></td>
				<td><input type="text" name="numero" id="numero"
					required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
			<tr>
				<td><label> Type de voie </label></td>
				<td><select name="voie" id="voie"
					style="margin-top: 6px; margin-bottom: 6px;">
						<option value="rue">rue</option>
						<option value="avenue">avenue</option>
						<option value="boulevard">boulevard</option>
						<option value="impasse">impasse</option>
						<option value="place">place</option>
				</select></td>
			</tr>
			<tr>
				<td><label> Nom de la rue </label></td>
				<td><input type="text" name="rue" id="rue" required="required"
					style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
			<tr>
				<td><label> Code postal </label></td>
				<td><input type="text" name="codePostal" id="codePostal"
					required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
			<tr>
				<td><label> Ville </label></td>
				<td><input type="text" name="ville" id="ville"
					required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
		</table>
		<br>
		<button type="submit">Ajouter</button>
	</form>
	<script>hideAddAddressForm();</script>
</div>
