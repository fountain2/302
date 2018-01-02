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
			<span class="title">维护学生成绩</span>
		</div>

		<div class="main-body">
			<form name="form" method="POST" action="addGrade.do"
				onsubmit="return checkForm();">
				<!-- <input type="hidden" name="student" value="${grade.student }">
				<input type="hidden" name="stuid" value="${grade.student.stuNumber }"> -->
				<input type="hidden" name="grade_id" value="${grade.id}">
				<input type="hidden" name="flag" value="update">

				<table class="main-table" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td class="first">
							学 号：
						</td>
						<td>
							<input type="text" name="studentID" maxlength="20" size="30"
								value="${grade.student.stuNumber }" class="bbsInput_short" disabled>
						</td>
					</tr>
					<tr>
						<td class="first">
							学生姓名：
						</td>
						<td>
							<input type="text" name="name" maxlength="20" size="30"
								value="<c:out value="${grade.student.username}"></c:out>"
								class="bbsInput_short" disabled>
						</td>
					</tr>

					
					<tr>
						<td class="first">
							修改的课程：
						</td>
						<td>
							<input type="text" name="grade_numCourse" maxlength="20" size="30"
								value="${grade.numCourse}" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							分数：
						</td>
						<td>
							<input type="text" name="grade_numScore" maxlength="20" size="30"
								value="${grade.numScore}" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td height="22" colspan="4">
							<div align="center">
								<input type="submit" value="保 存" class="bbsbutton">
								
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
							请仔细核对学生的成绩，确认所输入的信息是正确的，如果本次输入错了，保存成功后，还可以继续修改。
						</td>
					</tr>

				</table>
				<!-- <input type="hidden" name="from" value="${from}" /> -->
			</form>
		</div>

		<t:foot />
	</body>
</html>
