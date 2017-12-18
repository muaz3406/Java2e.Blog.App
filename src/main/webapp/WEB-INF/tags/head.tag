<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta" --%>

<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge; chrome=1"/>
	<title>${meta.title}</title>
	<script>var contextPath = "${pageConext.request.contextPath}"</script>
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link type="text/css" rel="stylesheet"
	href="<c:url value="/webjars/materialize/0.97.6/dist/css/materialize.min.css"/>"
	media="screen,projection"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link href="<c:url value="css/style.css"/>" type="text/css" rel="stylesheet" 
	media="screen,projection"/>
	<jsp:doBody/>
</head>