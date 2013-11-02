<div id="stylized" class="addform">
	<form id="form" name="form" method="post" action="addcontact">
		<h1>Ajouter un contact</h1>
		<p>Cette page vous permet d'ajouter un contact à votre répertoire</p>

		<table>
			<tr>
				<td><label> Prénom <span class="small"> Prénom
							du contact </span>
				</label></td>
				<td><input type="text" name="prenom" id="prenom" required="required" /></td>
			</tr>
			<tr>
				<td><label> Nom <span class="small"> Nom du
							contact </span>
				</label></td>
				<td><input type="text" name="nom" id="nom" required="required" /></td>
			</tr>
			<tr>
				<td><label> E-mail <span class="small"> Adresse
							e-mail </span>
				</label></td>
				<td><input type="email" name="email" id="email" required="required" /></td>
			</tr>
			<tr>
				<td><label> Date de Naissance <span class="small">
							Du nouveau contact </span>
				</label></td>
				<td><input type="date" name="dateNaissance" id="dateNaissance" required="required" /></td>
			</tr>
			<tr>
				<td><label> Actif <span class="small"> Le
							contact est-il actif </span>
				</label></td>
				<td><input type="checkbox" name="actif" id="actif" /></td>
			</tr>
		</table>
		<br>
		<div id="addresses"></div>
		<a href="javascript:showAddAddressForm()"><span id="add_msg">Ajouter une adresse au contact</span></a>
		<br>
		<br>
		<!-- Les 5 champs cachés suivants servent à sauvegarder les adresses ajoutées -->
		<input type="hidden" name="intituleHide" id="intituleHide" />
		<input type="hidden" name="numeroHide" id="numeroHide" />
		<input type="hidden" name="voieHide" id="voieHide" />
		<input type="hidden" name="rueHide" id="rueHide" />
		<input type="hidden" name="codePostalHide" id="codePostalHide" />
		<input type="hidden" name="villeHide" id="villeHide" />
		
		<button type="submit">Valider</button>

		<div class="spacer"></div>
	</form>
	<form id="addAddressForm" name="addAddressForm" method="post"
		action="javascript:addAddress()">
		<p>&nbsp;</p>

		<h3>Ajouter une adresse au contact</h3>

		<table>
			<tr>
				<td><label> Intiltulé de l'Adresse <span class="small">
							Maison, Bureau etc. </span></label></td>
				<td><input type="text" name="intitule" id="intitule" required="required" /></td>
			</tr>
			<tr>
				<td><label> Numéro de rue</label></td>
				<td><input type="text" name="numero" id="numero" required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
			<tr>
				<td><label> Type de voie </label></td>
				<td><select name="voie" id="voie" style="margin-top: 6px; margin-bottom: 6px;">
							<option value="rue">rue</option>
							<option value="avenue">avenue</option>
							<option value="boulevard">boulevard</option>
							<option value="impasse">impasse</option>
							<option value="place">place</option>
				</select></td>
			</tr>
			<tr>
				<td><label> Nom de la rue </label></td>
				<td><input type="text" name="rue" id="rue" required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
			<tr>
				<td><label> Code postal </label></td>
				<td><input type="text" name="codePostal" id="codePostal" required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
			<tr>
				<td><label> Ville </label></td>
				<td><input type="text" name="ville" id="ville" required="required" style="margin-top: 6px; margin-bottom: 6px;" /></td>
			</tr>
		</table>
		<br>
		<button type="submit">Ajouter</button>
	</form>
	<script>hideAddAddressForm()</script>
</div>
