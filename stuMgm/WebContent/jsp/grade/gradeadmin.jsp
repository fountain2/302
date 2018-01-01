<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript" src="html/js/manageGrade.js"></script>
		<link rel="stylesheet" href="html/css/grade.css" type="text/css"></link>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">学生成绩管理</span>
		</div>

		<div class="main-body">
			<form name="gradeForm" method="POST">
				<table class="main-table" cellspacing="0" width="100%" border="1"
					align="center">
					<tr class="title">
						<td>
							&nbsp;
						</td>
						<td>
							学号
						</td>
						<td class="name">
							姓名
						</td>
						<td>
							课程
						</td>
						<td>
							分数
						</td>
					</tr>
					<c:forEach items="${gradelist}" var="grade">
						<c:set var="student" value="${grade.student}"></c:set>
						<tr>
							<td>
								<input type=checkbox id="${grade.id}"
									value="${grade.id}">
							</td>
							<td>
								${student.stuNumber}
							</td>
							<td>
								<c:out value="${student.username}"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numCourse}"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numScore}"></c:out>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${empty gradelist}">
						<tr bgcolor="#ffffff">
							<td colspan=12>
								所有学生都没有成绩，请返回
								<a class="a2" href="studentAdmin.do?rnd=<%=Math.random()%>">学生基本信息管理</a>先添加成绩!
							</td>
						</tr>
					</c:if>

					<tr>
						<td colspan="12" class="ctrl-button">
							<input type=hidden name="studentids" value="">
							<input type="hidden" name="from" value="gradeadmin">
							<input type=button name="allcheck" value="全选"
								onclick=javascript:checkall(gradeForm);>
							<input type=button name="allnotcheck" value="全不选"
								onclick=javascript:uncheckall(gradeForm);>
							<input type=button name="delete" value="删除"
								onclick=javascript:deletegrade(gradeForm);>
							<input type=button name="addgrade" value="维护学生成绩"
								onclick=javascript:modifygrade(gradeForm);>
						</td>
					</tr>

				</table>
			</form>
		</div>

		<t:foot />
	</body>
</html>