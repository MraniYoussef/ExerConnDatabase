<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Produits</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container col-md-10 col-md-offset-1" >
	<div class="panel panel-primary">
		<div class=panel-heading> Ajouter Produit </div>
		<div class="panel-body">
			<form action="saveProduit.get" method="post">
			<div class="form-group">
				<label class="control-label">Code : </label>
				<input type="text" name="code" value="${produit.code }  " class="form-control" required="required"/>
				<span></span>
			</div>
			<div class="form-group">
				<label class="control-label">Désignation : </label>
				<input type="text" name="designation" value="${produit.designation }" class="form-control" />
				<span></span>
			</div>
			
			<div>
				<button class="btn btn-primary">Ajouter</button>
			</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>