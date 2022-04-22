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
		<div class=panel-heading> Confirmation </div>
		<div class="panel-body">
			<div class="form-group">
				<label>Code : </label>			
				<label>${produit.code }</label>
			</div>
			<div>
				<label>Designation : </label>			
				<label>${produit.designation }</label>
			</div>
			
		</div>
	</div>
	</div>
</body>
</html>