<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container col-md-10 col-md-offset-1" >
	<div class="panel panel-success">
		<div class=panel-heading> Chercher Produits </div>
		<div class="panel-body">
			<form action="chercher.get" method="get">
				<label>Keyword</label>
				<input type="text" name="keyword" value="${model.keyword }"/>
				<button type="submit" class="btn btn-success">Chercher</button>
			</form>
			<table class="table table-success table-striped">
				<tr>
					<th>CODE</th> <th>DESIGNATION</th> 
				</tr>
				<c:forEach items="${model.listProduits}" var="produit">
					<tr>
						<td>${produit.code}</td>
						<td>${produit.designation}</td>
						
						<td><a onclick="return confirm('êtes vous sûre de vouloir supprimer ce produit ?')" href="supprimer.get?code=${produit.code}">Supprimer</a></td>
						<td><a onclick="return confirm('êtes vous sûre de vouloir modifier ce produit ?')" href="modifier.get?code=${produit.code}">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</div>	
</body>
</html>