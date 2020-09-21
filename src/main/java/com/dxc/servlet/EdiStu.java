package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.beans.Student;
import com.dxc.dao.StudentJdbcDAO;
import com.dxc.service.StudentServiceImpl;

/**
 * Servlet implementation class EdiStu
 */
public class EdiStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdiStu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editForm(response,false);
    }   
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
         
        String email=request.getParameter("email");  
        String mobile=request.getParameter("mobile");  
          
        Student student = new Student(id);
        student.setId(id);  
        student.setName(name);  
        student.setEmail(email);  
        student.setMobile(mobile);  
          
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl(); 
        boolean boolea=studentServiceImpl.update(student);
        response.sendRedirect("Stud.jsp");

          
        out.close();
	}
	
	protected void editForm(HttpServletResponse response, boolean error) throws  IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");

		out.println("<title>Edit Student</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method =\"post\">");
		out.println("Id : <input type=\"text\" name=\"id\"><br>");
		out.println("Name : <input type=\"text\" name=\"name\"><br>");
		out.println("Email : <input type=\"text\" name=\"email\"><br>");
		out.println("Mobile : <input type=\"text\" name=\"mobile\"><br>");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("<input type=\"reset\"\" name=\"cancel\">");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
