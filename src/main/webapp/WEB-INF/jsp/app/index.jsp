<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/loadingbar.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/app-styles.css">
	<!-- link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css" -->
	<title>EduStat - Estadísticas en tu IE</title>
	<script type="text/javascript">
		var contextPath = '${pageContext.request.contextPath}';
		var baseUrl = '${pageContext.request.contextPath}/private/api/';
		var userData = ${usuarioJson};
		var menuData = ${menusJson};
	</script>
</head>
<body>
	<div class="header">
		<div class="row">
			<div id="top-bar" class="col-sm-12"></div>
		</div>
	</div>
	<div id="main-container">
		<div class="contents-wrapper">
			<div id="menu-wrapper" class="pull-left"></div>
			<div class="contents">
				<div class="container-fluid">
					<div class="row">
						<div id="main" class="col-sm-12"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script data-main="${pageContext.request.contextPath}/resources/js/app/web-config.js" src="${pageContext.request.contextPath}/resources/js/libs/require.js"></script>
</body>
</html>