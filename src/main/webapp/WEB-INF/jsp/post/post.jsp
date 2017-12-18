<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%--@elvariable id="meta" type="com.springblog.model.BlogMeta"--%>
<%--@elvariable id="post" type="com.springblog.model.Post"--%>
<%--@elvariable id="_USER" type="org.springframework.social.connect.UserProfile"--%>

<page:layout>
    <article>
        <div class="container">
            <div class="row">
                <div class="l8 offset-l2 m10 offset-m1">
                    <div class="right-align black-text text-lighten-3">Posted by <a
                            href="mailto:${meta.mail}">${meta.author}</a> on ${post.createdAt}</div>
                    <h1>${post.title}</h1>
                    <hr/>
                    <div>${post.content}</div>
                    <div class="row" style="padding-top: 2em;">
                        <div class="col offset-s2 s10">
                            <page:replyAddForm postId="${post.id}" idPrefix="pre-"/>
                            <c:forEach var="reply" items="${post.replyList}">
                                <div class="row">
                                    <div class="s3">${reply.name}</div>
                                    <div class="s9">${reply.comment}</div>
                                    <div class="right">
                                        <a href="/post/${post.id}/reply/${reply.id}/modify">
                                            <button type="button" class="btn">Edit</button>
                                        </a>

                                        <button type="button" class="btn"
                                                onclick="ajaxDelete('/post/${post.id}/reply/${reply.id}')">
                                            Delete
                                        </button>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:if test="${post.replyList.size() > 0}">
                                <page:replyAddForm postId="${post.id}" idPrefix="post-"/>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${_USER != null}">
                <div class="row">
                    <div class="right">
                        <a href="/post/${post.id}/modify">
                            <button type="button" class="btn">Edit</button>
                        </a>
                        <a href="/post/${post.id}/delete" onclick="if(!confirm('Are you sure you want to delete?')){return false;}">
                            <button type="button" class="btn">Delete</button>
                        </a>
                    </div>
                </div>
            </c:if>
        </div>
    </article>
</page:layout>
