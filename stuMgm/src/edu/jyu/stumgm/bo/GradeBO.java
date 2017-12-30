package edu.jyu.stumgm.bo;

import java.util.List;

import edu.jyu.stumgm.dao.IGradeDAO;
import edu.jyu.stumgm.dao.IStudentDAO;
import edu.jyu.stumgm.entity.Grade;
import edu.jyu.stumgm.entity.Student;

public class GradeBO {
	private IGradeDAO gradeDAO;
	private IStudentDAO studentDAO;

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public void setGradeDAO(IGradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	public void saveGrade(Grade grade) {
		gradeDAO.update(grade);
	}

	/**
	 * 修改已维护的学生成绩
	 * 
	 * @param grade
	 *            @
	 */
	public void updateGrade(Grade grade) {
		gradeDAO.update(grade);
	}

	/**
	 * 根据学生列表删除学生成绩
	 * 
	 * @param studentId
	 */
	public void deleteGradeByStudentsNumber(List<String> numbers) {
		gradeDAO.deleteByStudentsNumbers(numbers);

	}

	/**
	 * 得到所有的 学生成绩列表
	 * 
	 */
	public List<Student> getAllStudentsGrade() {
		return studentDAO.findAll();
	}
	
	public List<Grade> getAllGrade() {
		return gradeDAO.findAll();
	}

	/**
	 * 根据学号得到学生成绩
	 */
	public Grade getGradeByStudentNumber(String stuNumber) {
		return gradeDAO.findByStudentNumber(stuNumber);
	}

	/**
	 * 
	 按指定的条件搜索学生成绩列表（小于多少分 ）
	 */
	public List<Grade> findGradeByScoreLessThan(int searchkey) {
		return gradeDAO.findByScoreLessThan(searchkey);
	}

	/**
	 * 按指定的条件搜索前几名的学生成绩列表
	 */
	public List<Grade> getFirstStudentsGrade(int number) {
		return gradeDAO.findOrderBySum(number, false);
	}

	/**
	 * 按学号或姓名搜索学生成绩列表
	 */
	public List<Grade> findGradebyStudentNumberOrName(String searchKey) {
		return gradeDAO.findGradebyStudentNumberOrName(searchKey);
	}

	/**
	 * 删除某个学生的成绩
	 * 
	 * @param stuNumber
	 */
	public void deleteGrade(String stuNumber) {
		gradeDAO.deleteByStudentNumber(stuNumber);
	}

	/**
	 * 删除所有学生的成绩 
	 */
	public void deleteAllGrade() {
		gradeDAO.deleteAll();
	}

	/**
	 * 判断某个学生是否存在成绩
	 * 
	 * @param stuNumber
	 * @return boolean
	 */
	public boolean isExistSTUIDGrade(String stuNumber) {
		return gradeDAO.findByStudentNumber(stuNumber) != null;
	}

}