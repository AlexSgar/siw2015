<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserisci nuovo prodotto</title>
</head>
<body>
	<form action="productController" method="get" style="display: block">
		<div>Nome: <input type="text" name="name" value="${param.name}" /> ${nameError}</div>
		<div>Codice: <input type="text" name="code" value="${param.code}"/>${codeError}</div>
		<div>Descrizione: <input type="text" name="description" value="${param.description}"/>${descriptionError}</div>
		<div>Prezzo: <input type="text" name="price" value="${param.price}"/>${priceError}</div>
		<input type="submit" name="submit" value="invia"/>
	</form>
	
</body>
</html>