package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Student;

public interface IStudentDAO {
	public void save(Student student) ;

	public Student get(Serializable stuNumber) ;
	
	public void update(Student student) ;

	public void delete(Student student);

	public void delete(String stuNumber);
	
	public List<Student> findAll();
	
	/**
	 * 根据key进行模糊匹配查找
	 * @param key
	 * @return
	 */
	public List<Student> findByKey(String key);

	public void deleteByNumbers(List<String> numbers);
}