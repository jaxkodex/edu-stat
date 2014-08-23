<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/loadingbar.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<!-- link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css" -->
	<title>EduStat - Estadísticas en tu IE</title>
	<script type="text/javascript">
		var baseUrl = '${pageContext.request.contextPath}';
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div id="menu" class="col-sm-2"></div>
			<div class="col-sm-10">
				<div id="header" class="col-sm-12"></div>
				<div id="main" class="col-sm-12"></div>
			</div>
		</div>
		<div class="row">
			<div id="footer" class="col-sm-12"></div>
		</div>
	</div>

	<script data-main="${pageContext.request.contextPath}/resources/js/app/main-config.js" src="${pageContext.request.contextPath}/resources/js/require.js"></script>
</body>
</html>