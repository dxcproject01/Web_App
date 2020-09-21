package com.dxc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import com.dxc.beans.Exam;

import com.dxc.dao.ExamJdbcDAO;




public class ExamServiceImpl implements ExamService {

	@SuppressWarnings("finally")
	@Override
	public boolean save(Exam exam) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			ExamJdbcDAO examJdbcDAO = new ExamJdbcDAO();
		    res = examJdbcDAO.save(exam);
			if(res) {
				examJdbcDAO.save();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return res;
		}
	}

	@Override
	public Exam find(int eid) {
		// TODO Auto-generated method stub
		Exam exam = null;
		try {
			ExamJdbcDAO examJdbcDAO = new ExamJdbcDAO();
			exam = examJdbcDAO.find(eid);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return exam;
	}

	@Override
	public List<Exam> findAll() {
		// TODO Auto-generated method stub
		List<Exam> exams=null;
		try {
			ExamJdbcDAO examJdbcDAO = new ExamJdbcDAO();
            exams = examJdbcDAO.findAll();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return exams;
	}

	@Override
	public boolean update(Exam exam) {
		boolean res = false;
		try {
			ExamJdbcDAO examJdbcDAO = new ExamJdbcDAO();
			res = examJdbcDAO.edit(exam);
			if(res) {
				examJdbcDAO.save();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int eid) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			ExamJdbcDAO examJdbcDAO = new ExamJdbcDAO();
            res = examJdbcDAO.delete(eid);
			if(res) {
				examJdbcDAO.save();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	}

	


