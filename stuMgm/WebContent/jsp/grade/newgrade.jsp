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
			<span class="title">新增学生课程成绩</span>
		</div>

		<div class="main-body">
			
			<form name="form" method="get" action="addGrade.do"
				onsubmit="return checkForm();">
				<input type="hidden" name="flag" value="finish" />
				<input type="hidden" name="stuNumber" value="${student.stuNumber }" />
				<table class="main-table" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td class="first">
							学 号：
						</td>
						<td>
							<input type="text" name="stuNumber" maxlength="20" size="30"
								value="${student.stuNumber }" class="bbsInput_short" disabled>
						</td>
					</tr>
					<tr>
						<td class="first">
							学生姓名：
						</td>
						<td>
							<input type="text" name="username" maxlength="20" size="30"
								value="<c:out value="${student.username}"></c:out>"
								class="bbsInput_short" disabled>
						</td>
					</tr>

					
					<tr>
						<td class="first">
							新增科目：
						</td>
						<td>
							<input type="text" name="grade_numCourse" maxlength="20" size="30"
								value="" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							分数：
						</td>
						<td>
							<input type="text" name="grade_numScore" maxlength="20" size="30"
								value="" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td height="22" colspan="4">
							<div align="center">
								<input type="submit" value="创建" class="bbsbutton">
								
								&nbsp;&nbsp;
								<input type="reset" value="返 回" onclick="history.back(-1);"
									class="bbsbutton">
							</div>
						</td>


					</tr>
					<tr>
						<td colspan="2" class="note">
							<span class="title">注 意 事 项 ：</span>
							<br />
							
						</td>
					</tr>

				</table>
				<!-- <input type="hidden" name="from" value="${from}" /> -->
			</form>
		</div>

		<t:foot />
	</body>
</html>
