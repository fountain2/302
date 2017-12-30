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
				<input type="hidden" name="stuid" value="${student.stuNumber }">
				<input type="hidden" name="grade.id" value="${student.grade.id}">
				<input type="hidden" name="flag" value="update">

				<table class="main-table" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td class="first">
							学 号：
						</td>
						<td>
							<input type="text" name="studentID" maxlength="20" size="30"
								value="${student.stuNumber }" class="bbsInput_short" disabled>
						</td>
					</tr>
					<tr>
						<td class="first">
							学生姓名：
						</td>
						<td>
							<input type="text" name="name" maxlength="20" size="30"
								value="<c:out value="${student.username}"></c:out>"
								class="bbsInput_short" disabled>
						</td>
					</tr>

					<tr>
						<td class="first">
							电子技术：
						</td>
						<td>
							<input type="text" name="grade.numElectron" maxlength="20"
								size="30" value="${student.grade.numElectron}"
								class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							软件工程：
						</td>
						<td>
							<input type="text" name="grade.numSoftware" maxlength="20"
								size="30" value="${student.grade.numSoftware}"
								class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							计算机网络与信息安全：
						</td>
						<td>
							<input type="text" name="grade.numSecurity" maxlength="20"
								size="30" value="${student.grade.numSecurity}"
								class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							Java程序设计：
						</td>
						<td>
							<input type="text" name="grade.numJava" maxlength="20" size="30"
								value="${student.grade.numJava}" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							高级数据库：
						</td>
						<td>
							<input type="text" name="grade.numDB" maxlength="20" size="30"
								value="${student.grade.numDB}" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							图形图像处理技术：
						</td>
						<td>
							<input type="text" name="grade.numImage" maxlength="20" size="30"
								value="${student.grade.numImage}" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							分布计算与互联网技术：
						</td>
						<td>
							<input type="text" name="grade.numDistributed" maxlength="20"
								size="30" value="${student.grade.numDistributed}"
								class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td class="first">
							软件测试与自演化技术：
						</td>
						<td>
							<input type="text" name="grade.numTest" maxlength="20" size="30"
								value="${student.grade.numTest}" class="bbsInput_short">
						</td>
					</tr>
					<tr>
						<td height="22" colspan="4">
							<div align="center">
								<input type="submit" value="保 存" class="bbsbutton">
								&nbsp;&nbsp;
								<input type="reset" value="清 除" class="bbsbutton">
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
				<input type="hidden" name="from" value="${from}" />
			</form>
		</div>

		<t:foot />
	</body>
</html>
