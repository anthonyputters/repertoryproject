<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1.5">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/style.css" type="text/css"/>
<link rel="stylesheet" href="resources/css/menu.css" type="text/css"/>
<link rel="stylesheet" href="resources/css/new.css" type="text/css"/>
<link rel="stylesheet" href="resources/css/table.css" type="text/css"/>
<script src="resources/js/jquery-2.0.3.js"></script>
<script src="resources/js/script.js"></script>
<title>Repertory Project</title>
</head>
<body onLoad="javascript:openLink('repertory')">
	<div id='cssmenu'>
		<ul>
			<li id='li0' class='active' onclick="updateMenu(0);"><a href='javascript:openLink("repertory")'><span>Répertoire</span></a></li>
			<li id='li1' onclick="updateMenu(1);"><a href='javascript:openLink("newcontact")'><span>Ajouter</span></a></li>
			<li id='li2' onclick="updateMenu(2);"><a href='javascript:openLink("search")'><span>Rechercher</span></a></li>
			<li id='li3' class='last' onclick="updateMenu(3);"><a href='javascript:openLink("about")'><span>Crédits</span></a></li>
		</ul>
	</div>
	<div id="corps"></div>
</body>
</html>