<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags"%>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>
<%--@elvariable id="_USER" type="com.springframework.social.connect.UserProfile"--%>
<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfToken"--%>


<nav class="top-nav transparent">
	<div class="parallax-container">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="nav-wrapper">
					<a class="page-title">${meta.title}</a>
				</div>
				<div class="row-center">
					<h5 class="header col s12 light">${meta.greeting}</h5>
				</div>
			</div>
			<div class="parallax">
				<img src="<c:url value="/image/background1.jpg"/>" />
			</div>
		</div>
	</div>
</nav>
<div class="container">
	<a href="#" data-activates="nav-mobile"
		class="button-collapse top-nav full hide-on-large-only"> <i
		class="material-icons">menu</i>
	</a>
</div>
<ul id="nav-mobile" class="side-nav fixed">
	<li class="logo bold"><a id="logo-container"
		href="<c:url value="/"/>" class="brand-logo waves-effect waves-teal">
			HOME </a></li>
	<li class="search">
		<form method="get" action="<c:url value="/post/list"/>">
			<div class="search-wrapper card">
				<input id="search" name="search"><i class="material-icons">search</i>
				<div class="search-results"></div>
			</div>
		</form>
	</li>






</ul>