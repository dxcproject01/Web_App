package com.dxc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.dxc.beans.Mark;

import com.dxc.dao.MarkJdbcDAO;


public class MarkServiceImpl implements MarkService {

	@SuppressWarnings("finally")
	@Override
	public boolean save(Mark mark) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
		    res = markJdbcDAO.save(mark);
			if(res) {
				markJdbcDAO.save();
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
	public Mark find(int id) {
		// TODO Auto-generated method stub
		Mark mark = null;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
			mark = markJdbcDAO.find(id);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mark;
	}

	@Override
	public List<Mark> findAll() {
		// TODO Auto-generated method stub
		List<Mark> marks=null;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
			marks = markJdbcDAO.findAll();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marks;
	}

	@Override
	public boolean update(Mark mark) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
			res = markJdbcDAO.edit(mark);
			if(res) {
				markJdbcDAO.save();
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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			MarkJdbcDAO markJdbcDAO = new MarkJdbcDAO();
			res = markJdbcDAO.delete(id);
			if(res) {
				markJdbcDAO.save();
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
