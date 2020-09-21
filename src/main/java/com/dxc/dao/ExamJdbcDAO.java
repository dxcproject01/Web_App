package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Exam;
import com.dxc.util.ConnectionManager;

public class ExamJdbcDAO extends JdbcDAO implements DAO<Exam> {

	public ExamJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Exam e) throws Exception {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO exam VALUES(?,?)");
		pstmt.setInt(1, e.getEid());
		pstmt.setString(2, e.getEname());
		
		if(1== pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public boolean edit(Exam e) throws Exception {
    boolean res = false;
		
		PreparedStatement pstmt = con.prepareStatement("UPDATE exam SET ename=?  WHERE eid = ?");
		pstmt.setString(1, e.getEname());
		
		if(1 == pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public boolean delete(int eid) throws Exception {
    boolean res = false;
		
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM exam WHERE eid = ?");
		pstmt.setInt(1, eid);
		if(1== pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public Exam find(int eid) throws Exception {
    Exam exam = null;
		
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exam WHERE eid = ?");
			
			pstmt.setInt(1, eid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String ename = rs.getString(2);
				exam = new Exam(eid, ename);
			}
		}
		finally {
			con.close();
		}
		
		return exam;
	}

	@Override
	public List<Exam> findAll() throws Exception {
		ArrayList<Exam> exams = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM exam");
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				Exam exam = new Exam(eid, ename);
				exams.add(exam);
			}
		}
		finally {
			con.close();
		}
		
		
		return exams;
	}

	

}
