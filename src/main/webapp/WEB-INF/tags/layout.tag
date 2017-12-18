<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.sprinframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:html>
	<page:head>
	</page:head>
	<page:body>
		<header>
			<page:nav/>
		</header>
		<main>
			<jsp:doBody/>
		</main>
		<footer class="page-footer teal">
			<page:footer/>
		</footer>
		<page:js/>
		<page:scripts method="pop"/>
	</page:body>
</page:html>