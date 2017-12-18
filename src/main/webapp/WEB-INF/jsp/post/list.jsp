<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>
<%--@elvariable id="search" type="java.lang.String"--%>
<%--@elvariable id="posts" type="org.springframework.data.domain.Page<com.springblog.model.Post>"--%>

<page:layout>
    <div class="container">
        <c:if test="${search != null && search.length() > 0}">
            <div>
                <i class="cyan-text">${search}</i>For You
            </div>
        </c:if>
        <jsp:include page="/post/list.section" flush="true"/>
    </div>
</page:layout>