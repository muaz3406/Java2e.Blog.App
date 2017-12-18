<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="postId" required="true" type="java.lang.Long" %>
<%@attribute name="idPrefix" required="true" type="java.lang.String" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>
<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfToken"--%>

<form method="post" action="/post/${postId}/reply" class="row" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="input-field col s6">
        <i class="material-icons prefix">person_pin</i>
        <input id="${idPrefix}name" name="name" class="validate" length="32"/>
        <label for="${idPrefix}name" class="active">NAME</label>
    </div>
    <div class="input-field col s6">
        <i class="material-icons prefix">lock</i>
        <input id="${idPrefix}password" name="password" class="validate" length="32"/>
        <label for="${idPrefix}password" class="active">PASSWORD</label>
    </div>
    <div class="input-field col s12">
        <textarea id="${idPrefix}comment" name="comment" class="materialize-textarea" length="1024"></textarea>
        <label for="${idPrefix}comment">Textarea</label>
    </div>
    <div class="col s12 right-align">
        <button type="submit" class="btn">comment</button>
    </div>
</form>