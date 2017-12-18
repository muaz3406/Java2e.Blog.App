<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfToken"--%>

<script>
	var _csrf = {
		header : '${_csrf.headerName}',
		name : '${_csrf.parameterName}',
		token : '${_csrf.token}'
	};
</script>
<script type="text/javascript"
	src="<c:url value="/webjars/jquery/2.1.4/dist/jquery.min.js"/>"</script>
<script type="text/javascript"
	src="<c:url value="/webjars/materialize/0.97.6/dist/css/materialize.min.js"/>">
	
</script>
<script src="<c:url value="/js/depend.func.js"/>"></script>
<script src="<c:url value="/js/depend.use.strict.js"/>"></script>
<script src="<c:url value="/js/init.js"/>"></script>
<script>
	var $ = jQuery;
</script>