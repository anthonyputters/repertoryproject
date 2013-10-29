function updateMenu(id) {
	document.getElementById("li"+id).className = 'active';
	for(var i = 1 ; i < 4 ; i++)
		document.getElementById("li"+ (id+i) % 4).className = '';
}

function openLink(givenUrl) {
    $.ajax({
        url : givenUrl,
        method: "GET",          
        success : function(response) {
            $('#corps').html(response);
        }
    });
}

function hideAddAddressForm() {
	jQuery('#addAddressForm').hide();	
}

function showAddAddressForm() {
	jQuery('#addAddressForm').toggle(400);
}

function addAddress() {
	jQuery('#addAddressForm').toggle(400);

	var intitule = document.getElementById("intitule");
	var numero = document.getElementById("numero");
	var rue = document.getElementById("rue");
	var codePostal = document.getElementById("codePostal");
	var ville = document.getElementById("ville");
	
	document.getElementById("intituleHide").value += intitule.value + ";";
	document.getElementById("numeroHide").value += numero.value + ";";
	document.getElementById("rueHide").value += rue.value + ";";
	document.getElementById("codePostalHide").value += codePostal.value + ";";
	document.getElementById("villeHide").value += ville.value + ";";

	document.getElementById("addresses").innerHTML += "<b>" + intitule.value + "</b> - " + numero.value + " rue " + rue.value + ", " + codePostal.value + " " + ville.value + "<br>";
	
	intitule.value = "";
	numero.value = "";
	rue.value = "";
	codePostal.value = "";
	ville.value = "";
}

function addAddressModifyForm() {
	var contactHashCode = document.getElementById("contactHashCode");
	var intitule = document.getElementById("intitule");
	var numero = document.getElementById("numero");
	var rue = document.getElementById("rue");
	var codePostal = document.getElementById("codePostal");
	var ville = document.getElementById("ville");

	openLink("addaddress?contactHashCode="+contactHashCode.value+"&intitule="+intitule.value+"&numero="+numero.value+"&rue="+rue.value+"&codePostal="+codePostal.value+"&ville="+ville.value);
}
