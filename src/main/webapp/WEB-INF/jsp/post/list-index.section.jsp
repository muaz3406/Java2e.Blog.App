<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>
<%--@elvariable id="posts" type="org.springframework.data.domain.Page<com.springblog.model.Post>"--%>

<ul class="staggered">
    <c:forEach var="post" items="${posts.content}">
        <li><page:postCard post="${post}"/></li>
    </c:forEach>
</ul>

<ul class="row">
    <c:if test="${!posts.first}">
        <li class="left">
            <c:set var="number" value="${posts.number - 1}"/>
            <a href="?page=${number}"><< Newer Posts</a>
        </li>
    </c:if>
    <c:if test="${!posts.last}">
        <li class="right">
            <c:set var="number" value="${posts.number + 1}"/>
            <a href="?page=${number}">Older Posts >></a>
        </li>
    </c:if>
</ul>
