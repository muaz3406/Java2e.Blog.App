<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>
<%--@elvariable id="posts" type="org.springframework.data.domain.Page<com.springblog.model.Post>"--%>

<c:forEach var="post" items="${posts.content}">
    <page:postCard post="${post}"/>
</c:forEach>

<ul class="row pagination center-align">
    <c:set var="start" value="${posts.number - 5 > 0 ? posts.number - 5 : 0}"/>
    <c:set var="end" value="${posts.number + 5 < posts.totalPages -1 ? posts.number + 5 : posts.totalPages -1}"/>

    <c:if test="${end < 0}">
        No
    </c:if>

    <c:if test="${end >= 1}">
        <c:if test="${posts.number != 0}">
            <li>
                <a href="<c:url value="/post/list?page=0&search=${search}"/>"> <i
                        class="material-icons">chevron_left</i>
                </a>
            </li>
        </c:if>
        <c:forEach var="num" begin="${start}" end="${end}">
            <c:choose>
                <c:when test="${posts.number == num}">
                    <li class="disabled"> ${num + 1} </li>
                </c:when>
                <c:otherwise>
                    <li class="waves-effect"><a
                            href="<c:url value="/post/list?page=${num}&search=${search}"/>"> ${num + 1} </a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${posts.number != posts.totalPages - 1}">
            <li>
                <a href="<c:url value="/post/list?page=${posts.totalPages - 1}&search=${search}"/>"> <i
                        class="material-icons">chevron_right</i></a>
            </li>
        </c:if>
    </c:if>
</ul>