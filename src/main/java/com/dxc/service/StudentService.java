package com.dxc.service;

import java.util.List;

import com.dxc.beans.Student;

public interface StudentService {
	
	boolean save(Student student);
	Student find (int id);
	List<Student>findAll();
	boolean update(Student student);
	boolean delete(int id);

}
