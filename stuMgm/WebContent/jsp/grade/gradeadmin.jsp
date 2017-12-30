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
							电子技术
						</td>
						<td>
							软件工程
						</td>
						<td>
							计算机网络与信息安全
						</td>
						<td>
							Java程序设计
						</td>
						<td>
							高级数据库
						</td>
						<td>
							图形图像处理技术
						</td>
						<td>
							分布计算与互联网技术
						</td>
						<td>
							软件测试与自演化技术
						</td>
						<td>
							总 分
						</td>
					</tr>
					<c:forEach items="${gradelist}" var="grade">
						<c:set var="student" value="${grade.student}"></c:set>
						<tr>
							<td>
								<input type=checkbox id="${student.stuNumber}"
									value="${student.stuNumber}">
							</td>
							<td>
								${student.stuNumber}
							</td>
							<td>
								<c:out value="${student.username}"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numElectron}" default="0" />
							</td>
							<td class="num">
								<c:out value="${grade.numSoftware}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numSecurity}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numJava}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numDB}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numImage}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numDistributed}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.numTest}" default="0"></c:out>
							</td>
							<td class="num">
								<c:out value="${grade.total}" default="0"></c:out>
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