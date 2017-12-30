<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript" src="html/js/manageStudent.js"></script>
		<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">学生信息管理</span>
		</div>
		<div class="main-body">
			<form name="studentForm" method="POST">
				<table  class="main-table" cellpadding="0" cellspacing="0" align="center">
					<tr class="title">
						<td></td>
						<td>学号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>籍贯</td>
						<td>身份证号</td>
						<td>邮政编码</td>
						<td>电子邮件</td>
						<td>通讯地址</td>
					</tr>
					<c:forEach items="${studentlist}" var="stu">
						<tr>							
							<td>
								<input type=checkbox id="${stu.stuNumber}"
									value="${stu.stuNumber}">
							</td>
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
							<td colspan=9>
								没有任何学生信息，请先添加!
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan=9 class="ctrl-button">
							<input type=button name="allcheck" value="全选"
								onclick="checkall(studentForm);" />
							<input type=button name="allnotcheck" value="全不选"
								onclick="uncheckall(studentForm);" />
							<input type=button name="delete" value="删除"
								onclick="deletestudent(studentForm);" />
							<input type=button name="edit" value="修改学生信息"
								onclick="editstudent(studentForm);" />
							<input type=button name="addgrade" value="维护学生成绩"
								onclick="modifygrade(studentForm);" />
						</td>
					</tr>
				</table>
				<input type=hidden name="studentids" value="">
			</form>
			</div>
			<t:foot />
		</body>
</html>