package edu.jyu.stumgm.bo;

import java.util.Calendar;
import java.util.List;

import edu.jyu.stumgm.dao.IStudentDAO;
import edu.jyu.stumgm.entity.Student;

public class StudentBO {
	private IStudentDAO studentDAO;

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * 新加一条记录Student
	 * 
	 * @param student
	 * @throws Exception
	 */
	public void addStudent(Student student) {
		studentDAO.save(student);
	}

	/**
	 * 修改已建立的记录
	 * 
	 * @param student
	 *            
	 */
	public void updateStudent(Student student) {
		studentDAO.update(student);
	}

	/**
	 * 得到所有的Student列表
	 * @return @
	 */
	public List<Student> getAllStudents() {
		return studentDAO.findAll();

	}

	/**
	 * 根据学号得到学生姓名
	 * 
	 * @param stuNumber
	 * @return @
	 */
	public String getUserNameByID(String stuNumber) {
		Student stu = studentDAO.get(stuNumber);
		if (stu != null) {
			return stu.getUsername();
		}
		return null;
	}
	/**
	 * 按指定的条件搜索Student列表
	 * 
	 * @param searchkey
	 * @return @
	 */
	public List<Student> getSearchStudents(String searchkey) {
		return studentDAO.findByKey(searchkey);
	}

	/**
	 * 按学号取到学生信息
	 * 
	 * @param stuid
	 * @return @
	 */
	public Student getStudentByNumber(String stuNumber) {
		System.out.println("getStudentByNumber " + stuNumber);
		return studentDAO.get(stuNumber);
	}

	/**
	 * 删除Student
	 * @param STUID
	 */
	public void deleteStudent(String stuNumber) {
		studentDAO.delete(stuNumber);
	}
	
	public void deleteStudentsByNumber(List<String> numbers){
		studentDAO.deleteByNumbers(numbers);
	}

	/**
	 * 生成STUID，前四位是年份，后六位是随机数
	 * @return @
	 */
	public String generateStuNumber() {
		Calendar calendar = Calendar.getInstance();
		String stuNumber = "";
		int done = 1;
		while (done == 1) {
			stuNumber = "";
			stuNumber += calendar.get(Calendar.YEAR);
			double rand = Math.random() * 900000;
			long stuID = (long) (rand) + 100000;
			stuNumber += stuID;

			if (!isExistStuNumber(stuNumber)) {
				done = 0;
			}
		}
		return stuNumber;

	}

	/**
	 *判断学号是否存在
	 */
	private boolean isExistStuNumber(String stuNumber) {
		return studentDAO.get(stuNumber) != null;
	}
}