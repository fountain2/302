<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script type="text/javascript"
			src="html/js/validateStudentForm.js"></script>
		<script language="JavaScript">
		window.onload = function(){
			document.studentForm.onsubmit = validateStudentForm;	
		}
		</script>
		<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
		<style>
		.main-top{
			height:60px;
		}
		</style>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">添加新学生</span>
			<br />
			<span class="tip">新入学的学生或在数据库中不存在的学生，需要添加到此数据库中。</span>
		</div>
		<div class="main-body">
			<form name="studentForm" method="POST" action="addStudent.do"">
				<input type="hidden" name="flag" value="update" />
				<table class="main-table" cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="first">
							<span class="tip">*</span>学 号：
						</td>
						<td >
							<input type="text" name="student.stuNumber" maxlength="20"
								size="30" value="${stuid}">
						</td>
					</tr>
					<tr >
						<td class="first">
							<span class="tip">*</span>学生姓名：
						</td>
						<td >
							<input type="text" name="student.username" maxlength="20"
								size="30" value="">
						</td>
					</tr>

					<tr class="light">
						<td  class="first">
							<span class="tip">*</span>性 别：
						</td>
						<td>
							<select name="student.gender">
								<option value="1" selected>
									男
								</option>
								<option value="0">
									女
								</option>
							</select>
						</td>
					</tr>
					<tr >
						<td class="first">
							<span class="tip">*</span>籍 贯：
						</td>
						<td>
							<input type="text" name="student.city" maxlength="14" size="14"
								value="">市(如：北京市)
						</td>
					</tr>
					<tr class="light">
						<td class="first">
							<span class="tip"></span>身份证号：
						</td>
						<td>
							<input type="text" name="student.identityID" maxlength="18"
								size="30" value="">
						</td>
					</tr>
					<tr >
						<td class="first">
							联系电话：
						</td>
						<td>
							<input type="text" name="student.phone" maxlength="18" size="30"
								value="">
						</td>
					</tr>
					<tr class="light">
						<td class="first">
							邮政编码：
						</td>
						<td>
							<input type="text" name="student.postID" maxlength="6" size="30"
								value="">
						</td>
					</tr>
					<tr >
						<td class="first">
							电子邮件：
						</td>
						<td>
							<input type="text" name="student.email" maxlength="50" size="30"
								value="">
						</td>
					</tr>
					<tr class="light">
						<td class="first">
							通讯地址：
						</td>
						<td>
							<input type="text" name="student.address" maxlength="200"
									size="30" value="">
						</td>
					</tr>
					<tr >
						<td colspan="2" class="ctrl-button">
								<input type="submit" value="新 建">
								&nbsp;&nbsp;
								<input type="reset" value="清 除">
								&nbsp;&nbsp;
								<input type="reset" value="返 回" onclick="history.back(-1);">
						</td>
					</tr>
					<tr >
						<td colspan="2" class="note">							
							<span class="title">注 意 事 项 ：</span><br/>
							1. 请仔细核对学生的信息，确认所输入的信息是正确的，如果本次输入错了，添加成功后，还可以继续修改；<br/>
							2.<span class="tip">*</span> 为必填项，如果全部正确输入后,按“新 建”按钮进行创建。
									
						</td>
					</tr>

				</table>
			</form>
		</div>
		<t:foot />
	</body>
</html>