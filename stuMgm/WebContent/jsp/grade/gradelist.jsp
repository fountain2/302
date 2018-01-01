<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<link rel="stylesheet" href="html/css/grade.css" type="text/css"></link>
	</head>
	<body>
	<t:menu />
		<div class="main-top">
				<span class="title">学生成绩一览表</span>
		</div>	
				
		<div class="main-body">
		<table class="main-table" cellspacing="0" width="100%" border="1" align=center>
			<tr class="title">
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
				<tr>
					<td>
						${grade.student.stuNumber}
					</td>
					<td>
				 		<c:out value="${grade.student.username}"></c:out>
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
					<td height="22" align="center" colspan=11>
						所有学生都没有成绩，请添加成绩!
					</td>
				</tr>
			</c:if>

		</table>
		</div>

		<t:foot />
	</body>
</html>