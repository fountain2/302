function validateStudentForm(){
	var form = document.studentForm;
	if (form["student.stuNumber"].value.trim() == "") {
		alert("请输入学号.");
		form["student.stuNumber"].focus();
		return false;
	}
	if (form["student.username"].value.trim() == "") {
		alert("请输入学生姓名.");
		form["student.username"].focus();
		return false;
	}
	if (form["student.city"].value.trim() == "") {
		alert("请输入学生籍贯.");
		form["student.city"].focus();
		return false;
	}	
	if ((form["student.identityID"].value.trim() != "") && !isValidPID(form["student.identityID"].value)) {
		alert("身份证号码输入错，注意要在英文状态下输入15或18位数字.");
		form["student.identityID"].focus();
		return false;
	}
	if ((form["student.phone"].value.trim() != "") && !isValidNumber(form["student.phone"].value)) {
		alert("电话号码错，只能输入数字，区号中间可用-分隔，不能少于７位，也可以用手机号码.");
		form["student.phone"].focus();
		return false;
	}
	if ((form["student.postID"].value.trim() != "") && !isValidpostID(form["student.postID"].value)) {
		alert("邮政编码错，只能是六位数字.");
		form["student.postID"].focus();
		return false;
	}
	if ((form["student.email"].value.trim() != "") && !form["student.email"].value.match( /^.+@.+$/ ) ) {
		alert("Email 错误！请重新输入");
		form["student.email"].focus();
		return false;
	}
	return true;
}