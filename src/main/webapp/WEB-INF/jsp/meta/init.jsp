<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>

<page:layout>
    <div class="container">
        <h1>META CONFIG</h1>
        <div class="row">
            <form:form commandName="meta" action="/meta/init" method="post" enctype="multipart/form-data">
                <c:set var="variables">title,author,authorFacebookEmail,introduce,greeting,mail</c:set>
                <c:forEach var="var" items="${variables}">
                    <div class="input-field col l6 s12">
                        <i class="material-icons prefix">play_arrow</i>
                        <form:input path="${var}" class="validate" length="100"/>
                        <label for="${var}" class="active">${var}</label>
                    </div>
                </c:forEach>
                <div class="right-align">
                    <button class="btn-large waves-effect waves-light" type="submit">commit</button>
                </div>
            </form:form>
        </div>
    </div>
</page:layout>