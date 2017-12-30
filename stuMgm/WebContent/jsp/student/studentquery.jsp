<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<link rel="stylesheet" href="html/css/editStudent.css"
			type="text/css"></link>
		<script language="javascript">
			function query() {
				var querystr = document.studentForm.querystring.value;
				if (querystr.trim() == "") {
					alert("请输入需要查询的学生学号、姓名、籍贯或身份证号，再进行查询!");
					document.studentForm.querystring.focus();
					return;
				}
				document.studentForm.submit();
			}
		</script>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">学生信息查询</span>
		</div>
		<div class="main-body">
			<form name="studentForm" method="POST" action="studentSearchquery.do">
				<table class="main-table" cellpadding="0" cellspacing="0"
					align="center">
					<tr class="search-line">
						<td align="left" colspan="8">
							<font size=2>请输入需要查询的学生学号、姓名、籍贯、身份证号或信息中的任何关键字：
							<input type="text" name="querystring"> </font>
							<input type=button name="querybtn" value="查 询" onclick="query();"
>
						</td>
					</tr>
					<tr class="title">
						<td>
							学号
						</td>
						<td>
							姓名
						</td>
						<td>
							性别
						</td>
						<td>
							籍贯
						</td>
						<td>
							身份证号
						</td>
						<td>
							邮政编码
						</td>
						<td>
							电子邮件
						</td>
						<td>
							通讯地址
						</td>
					</tr>
					<c:forEach items="${studentlist}" var="stu">
						<tr>
							<td>
								<c:out value="${stu.stuNumber}"></c:out>
							</td>
							<td>
								<c:out value="${stu.username}" />
							</td>
							<td>
								<c:if test="${stu.gender eq '1'}">男</c:if>
								<c:if test="${stu.gender eq '0'}">女</c:if>
							</td>
							<td>
								<c:out value="${stu.city}" />
							</td>
							<td>
								<c:out value="${stu.identityID}" />
							</td>
							<td>
								<c:out value="${stu.postID}" />
							</td>
							<td>
								<c:out value="${stu.email}" />
							</td>
							<td>
								<c:out value="${stu.address}" />
							</td>
						</tr>
					</c:forEach>

					<c:if test="${empty studentlist}">
						<tr>
							<td colspan=8>
								<span class="error">没有任何学生信息!</span>
							</td>
						</tr>
					</c:if>
				</table>
			</form>
		</div>
		<t:foot />
	</body>
</html>