package com.dxc.beans;

public class Exam {
	int eid;
	String ename;
	
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	
	public Exam(String ename) {
		super();
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Exam [eid=" + eid + ", ename=" + ename + "]";
	}
	

}
