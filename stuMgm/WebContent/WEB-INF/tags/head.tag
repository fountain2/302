<%@tag pageEncoding="utf-8" body-content="empty"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@attribute name="title" required="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<TITLE><c:out value="${title}" default="大学学籍管理系统"></c:out></TITLE>
<base href="<%=basePath%>" />

<link href="html/css/main.css" type=text/css rel="stylesheet">
<script language=JavaScript src="html/js/common.js"></script>
