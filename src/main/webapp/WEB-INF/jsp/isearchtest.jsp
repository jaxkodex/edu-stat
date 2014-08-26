<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/loadingbar.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<!-- link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/backbone.modal.css" -->
	<title>EduStat - Estadísticas en tu IE</title>
	<script type="text/javascript">
		var baseUrl = '${pageContext.request.contextPath}/public/api/';
	</script>
</head>
<body>

	<div class="container" style="padding-top: 20px;">
		<div class="col-sm-12">
			<input id="testme" type="text" class="form-control input-sm" placeholder="Type here" />
		</div>
	</div>

	<script data-main="${pageContext.request.contextPath}/resources/js/test-search.js" src="${pageContext.request.contextPath}/resources/js/require.js"></script>
</body>
</html>