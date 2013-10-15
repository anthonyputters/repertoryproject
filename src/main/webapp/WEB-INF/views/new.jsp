<div id="stylized" class="myform" style="width:370px">
	<form id="form" name="form" method="post" action="addtorepertory">
		<h1>Ajouter un contact</h1>
		<p>Cette page vous permet d'ajouter un contact à votre répertoire</p>

		<label>
			Prénom 
			<span class="small">
				Prénom du contact
			</span>
		</label> 
		<input type="text" name="prenom" id="prenom" />
		
		<label>
			Nom 
			<span class="small">
				Nom du contact
			</span>
		</label> 
		<input type="text" name="nom" id="nom" /> 
		
		<label>
			E-mail 
			<span class="small">
				Adresse e-mail
			</span>
		</label> 
		<input type="text" name="email" id="email" /> 
		
		<label>
			Date de Naissance
			<span class="small">
				Du nouveau contact
			</span> 
		</label> 
		<input type="date" name="dateNaissance" id="dateNaissance" /> 
		
		<label>
			Actif 
			<span class="small">
				Le contact est-il actif
			</span>
		</label> 
		<input type="checkbox" name="actif" id="actif" />

		<br><br>
		<button type="submit">Ajouter</button>
		<div class="spacer"></div>
	</form>
</div>
