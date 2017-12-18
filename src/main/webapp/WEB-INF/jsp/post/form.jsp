<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:layout>
    <link rel="stylesheet" href="<c:url value="/webjars/pen/0.2.2/src/pen.css"/>"/>

    <div class="container">
        <div class="row">
            <div class="l8 offset-l2 m10 offset-m1">
                <form:form commandName="post"
                           action="/post/${ post.id == null ? 'add' : post.id.toString().concat('/modify')}"
                           method="post" enctype="multipart/form-data"
                           onsubmit="$('#content').val($('#pen').html()); pen.destroy();">

                    <form:input path="title" placeholder="title" cssStyle="font-size: 2em; font-weight: bold;"/>

                    <form:hidden path="content" id="content"/>

                    <div id="custom-toolbar" class="pen-menu"
                         style="display: block; margin:0 auto; position: relative;">
                        <i class="pen-icon icon-insertimage" data-action="insertimage"></i>
                        <i class="pen-icon icon-blockquote" data-action="blockquote"></i>
                        <i class="pen-icon icon-h1" data-action="h1"></i>
                        <i class="pen-icon icon-h2" data-action="h2"></i>
                        <i class="pen-icon icon-h3" data-action="h3"></i>
                        <i class="pen-icon icon-p active" data-action="p"></i>
                        <i class="pen-icon icon-code" data-action="code"></i>
                        <i class="pen-icon icon-insertorderedlist" data-action="insertorderedlist"></i>
                        <i class="pen-icon icon-insertunorderedlist" data-action="insertunorderedlist"></i>
                        <i class="pen-icon icon-inserthorizontalrule" data-action="inserthorizontalrule"></i>
                        <i class="pen-icon icon-indent" data-action="indent"></i>
                        <i class="pen-icon icon-outdent" data-action="outdent"></i>
                        <i class="pen-icon icon-bold" data-action="bold"></i>
                        <i class="pen-icon icon-italic" data-action="italic"></i>
                        <i class="pen-icon icon-underline" data-action="underline"></i>
                        <i class="pen-icon icon-createlink" data-action="createlink"></i>
                    </div>

                    <div data-toggle="pen" data-placeholder="Content" id="pen"
                         style="min-height: 200px;">${post.content}</div>

                    <div class="center">
                        <button type="submit" class="btn btn-large">저장</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <page:scripts>
        <script src="<c:url value="/webjars/pen/0.2.2/src/pen.js"/>"></script>
        <script type="text/javascript">
            var pen = new Pen({
                toolbar: document.getElementById('custom-toolbar'),
                editor: document.querySelector('[data-toggle="pen"]')
            });
        </script>
    </page:scripts>
</page:layout>
