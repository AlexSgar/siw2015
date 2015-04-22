<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mostra i prodotti</title>
</head>
<body>
	<h1>Lista prodotti inseriti</h1>
	<table style="width:50%">
	<tr ><td>Nome</td><td>Codice</td><td>Descrizione</td><td>Prezzo</td></tr>
	<c:forEach var="product" items="${products}">
	   <tr> <td>${product.name}</td>
	        <td>${product.code}</td>
	   		<td>${product.description}</td>
	   		<td>${product.price}</td>
	   </tr>
	</c:forEach>
	</table>
	<br />
	<button><a href="<c:url value="newProduct.jsp" />">aggiungi prodotto</a></button>
</body>
</html>