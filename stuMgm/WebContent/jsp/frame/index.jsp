<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript">
			function checkName() {
				var userName = document.form1.userName.value;
				var password = document.form1.password.value;
				if (userName.length == 0) {
					alert("请输入您的用户名.");
					document.form1.userName.focus();
				} else if ((userName.length) < 3 || (userName.length) > 20) {
					window.alert("用户名长度不合适，应在3-20位之间");
					document.form1.userName.focus();
				} else if ((password.length) == 0 || (password.length) < 3) {
					window.alert("密码不能为空,并至少是3位！");
					document.form1.password.focus();
				} else {
					form1.submit();
				}
			}
		</script>
	</head>
	<body>
		<t:menu />

		<c:if test="${loginError}">
			<c:set var="errorMsg">用户名或密码输入有误，请检查确认后，再重新登录！注意字符大小写要正确！！</c:set>
		</c:if>

		<div class="content">
			<FORM name=form1 action="login.do" method="POST">
				<table width="778" border="0" cellSpacing="3" cellPadding="0"
					bgColor="#E0FCDE">
					<c:if test="${empty user}">
						<!-- login页面-->
						<tr height="10">
							<td colspan="3">&nbsp;
								
							</td>
						</tr>
						<c:if test="${loginError}">
							<tr>
								<td width="120">
									&nbsp;&nbsp;
								</td>
								<td colSpan="2">
									&nbsp;&nbsp;&nbsp;
									<font color=red><br>${errorMsg}</font>
								</td>
							</tr>
						</c:if>
						<tr>
							<td width="30%">&nbsp;
								
							</td>
							<td colSpan="2">
								<b><u>请输入用户名与密码</u> </b>
							</td>

						</tr>

						<tr>
							<td width="30%">&nbsp;
								
							</td>
							<td colspan="2">
								用户名：
								<INPUT class=input_login id=userName maxLength=20 size=20
									name=userName>
							</td>
						</tr>

						<tr>
							<td>&nbsp;
								
							</td>
							<td colspan="2">
								密&nbsp;&nbsp;码：
								<INPUT class=input_login type=password maxLength=20 size=20
									name=password>
							</td>
						</tr>
						<tr>
							<td>&nbsp;
								
						  </td>
							<td>
								<a style="CURSOR: hand" href="javascript:checkName()"> <IMG
										alt=现在登录 src="html/pic/reg2.gif" width=75 border=0>								</a>							</td>
						</tr>

						<tr height="10">
							<td>&nbsp;
								
							</td>
						</tr>

						<!-- login页面结束-->
					</c:if>

					<c:if test="${not empty user}">

						<!-- 不显示login页面-->

						<tr>
							<td colspan="2" height="1" color="white"></td>
						</tr>
						<tr>
							<td colspan="2" height="85">
								<IMG src="html/pic/welcome.gif">
							</td>
						</tr>
						<tr>
							<td colspan="2" height="20" color="white">

							</td>
						</tr>

					</c:if>
				</table>
			</FORM>

			<table cellSpacing="0" cellPadding="6" width="778" border="1">
				<tr>
					<td align="left" bgColor="#f2f2f2">
						注意事顼：
					</td>
				</tr>
				<tr>
					<td style="LINE-HEIGHT: 25px" align="left">
						注意：建议使用IE及Firefox等高版本的浏览器,推荐使用IE8及Firefox 3.5等,其它的浏览器可能不能正常使用本系统；
						<BR>
						
					</td>
				</tr>
			</table>
		</div>
	</body>
	<t:foot />
</html>
