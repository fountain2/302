package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Grade;

public interface IGradeDAO {
	public void saveOrUpdate(Grade obj) ;
	
	public void save(Grade obj) ;

	public Grade get(Serializable id) ;
	
	/**
	 * new
	 * update 选中的列的信息
	 * @param obj
	 */
	public void update(Grade obj) ;

	public void delete(Grade obj);

	public void delete(Long id);
	
	/**
	 * 根据学号删除某个人的成绩
	 * @param stuNumber
	 */
	public void deleteByStudentNumber(String stuNumber);
	 
	public List<Grade> findAll();
	
	/**
	 * 根据学号批量删除成绩
	 * @param numbers
	 */
	public void deleteByStudentsNumbers(List<String> numbers);
	
	/** 
	 * 根据学生的学号查找成绩
	 * @param number
	 * @return
	 */
	public Grade findByStudentNumber(String number);
	
	/**
	 * 查找存在不高于指定分数的学生成绩
	 * @param score
	 * @return
	 */
	public List<Grade> findByScoreLessThan(int score);
	
	/**
	 * 按总分排序查询，
	 * @param number 查找多少个成绩
	 * @param isAsc 是否升序
	 * @return
	 */
	public List<Grade> findOrderBySum(int number, boolean isAsc);
	
	/**
	 * 根据学号或学生的姓名进行模糊查找
	 * @param key
	 * @return
	 */
	public List<Grade> findGradebyStudentNumberOrName(String key);
	
	public void deleteAll();
	
	/**
	 * new
	 * 根据grade_id 查找成绩列表
	 * @param stuid
	 * @return
	 */
	public Grade getGradeById(String stuid);
	
	/**
	 * new
	 * 将新建的课程插入表中
	 * @param grade
	 */
	public void insertTo(Grade grade);
}