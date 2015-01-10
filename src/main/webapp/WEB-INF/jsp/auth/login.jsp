<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/app-styles.css">
	<title>Iniciar Sesión | EduStat - Estadísticas en tu IE</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-12 clearfix">
			<ul class="nav nav-pills custom-nav pull-right">
				<li><a href="${pageContext.request.contextPath}#home">Inicio</a></li>
				<li><a href="${pageContext.request.contextPath}#signup">Registrarse</a></li>
				<li class="active"><a href="#">Iniciar sesión</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3">
			<c:if test="${error != null}">
			<div class="alert alert-danger">
			<p>La combinación Usuario/Contraseña no es correcta.</p>
			</div>
			</c:if>
			<form action="/edustat/j_spring_security_check" method="POST">
				<div class="form-group">
					<label for="username">Usuario</label>
					<input name="username" type="text" class="form-control input-sm" id="username" />
				</div>
				<div class="form-group">
					<label for="password">Contraseña</label>
					<input name="password" type="password" class="form-control input-sm" id="password" />
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-right">
						<input class="btn btn-sm btn-primary" type="submit" value="Ingresar" /> o <a href="${pageContext.request.contextPath}#signup">Registrate</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>