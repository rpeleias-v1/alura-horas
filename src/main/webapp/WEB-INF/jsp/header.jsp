<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Título</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" rel="javascript" />
</head>
<body>
	<header>
	</header>
	
	<nav>
		<ul class="nav nav-tabs">
			<li><a href="<c:url value='/' />">Home</a></li>
			<li><a href="<c:url value='/usuario/lista' />">Usuários</a></li>
			<li><a href="<c:url value='/horaLancada/lista' />">Horas Cadastradas</a></li>
			<li><a href="<c:url value='/horaLancada/form' />">Cadastrar Horas</a></li>
		</ul>
	</nav>
	
	<div class="container">
		<main class="col-sm-8" >