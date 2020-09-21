package com.dxc.service;

import java.util.List;

import com.dxc.beans.Exam;

public interface ExamService {
	
	boolean save(Exam exam);
	Exam find (int eid);
	List<Exam>findAll();
	boolean update(Exam exam);
	boolean delete(int eid);

}
