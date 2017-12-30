function checkall(form) {
	var cbxoption;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			cbxoption[i].checked = true;
		}
	}
}
function uncheckall(form) {
	var cbxoption;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			cbxoption[i].checked = false;
		}
	}
}
function deletestudent(form) {
	var stuids;
	var cbxoption;
	var m = 0;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					stuids = cbxoption[i].id;
				else
					stuids += "," + cbxoption[i].id;
			}
		}

		form.studentids.value = stuids;
	}
	if (m == 0) {
		alert("你没有选中需要删除的学生，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否将选中的学生信息删除?")){
	   	  	return; 
	   }
	}
	
	location.href = "deleteStudent.do?stuids=" + stuids;
}

function editstudent(form) {
	var cbxoption, studid, username;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m > 1) {
					alert("一次只能修改一个学生的信息，请重选！");
					return;
				}
				studid = cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要修改的学生，请重选！");
		return;
	}

	location.href = "editStudent.do?stuid=" + studid;
}

function modifygrade(form) {
	var cbxoption, studid, username;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m > 1) {
					alert("一次只能维护一个学生的成绩，请重选！");
					return;
				}
				studid = cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要维护成绩的学生，请重选！");
		return;
	}
	location.href = "addGrade.do?stuid=" + studid+"&flag=add";
}