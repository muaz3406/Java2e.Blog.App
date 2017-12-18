<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="post" required="true" type="kr.tinywind.blog.model.Post" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>

<a href="/post/${post.id}" class="card-panel card small hoverable waves-effect waves-block">
    <div class="card-title cyan-text text-darken-4">${post.title}</div>
    <div class="card-content black-text text-darken-4">${post.content}</div>
    <div class="card-action right-align black-text text-lighten-3">
        Posted by <strong>${meta.author}</strong> on <i><fmt:formatDate value="${post.createdAt}"
                                                                        pattern="yyyy-MM-dd"/></i>
    </div>
</a>