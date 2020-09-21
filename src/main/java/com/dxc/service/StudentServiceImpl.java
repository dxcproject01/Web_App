package com.dxc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.List;

import com.dxc.beans.Student;
import com.dxc.dao.StudentJdbcDAO;

public class StudentServiceImpl implements StudentService {

	@SuppressWarnings("finally")
	@Override
	public boolean save(Student student) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
		    res = studentJdbcDAO.save(student);
			if(res) {
				studentJdbcDAO.save();
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
	public Student find(int id) {
		Student student = null;
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			student = studentJdbcDAO.find(id);
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students=null;
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			students = studentJdbcDAO.findAll();
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public boolean update(Student student) {
		boolean res = false;
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			res = studentJdbcDAO.edit(student);
			if(res) {
				studentJdbcDAO.save();
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
		return false;
	}

	public  boolean delete(int id) {
		boolean res = false;
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			res = studentJdbcDAO.delete(id);
			if(res) {
				studentJdbcDAO.save();
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
		return false;
	}

}
