package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.beans.Exam;
import com.dxc.beans.Student;
import com.dxc.service.ExamServiceImpl;
import com.dxc.service.StudentServiceImpl;

/**
 * Servlet implementation class EdiExam
 */
public class EdiExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdiExam() {
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
		int eid = Integer.parseInt(request.getParameter("eid")) ;
		String ename=request.getParameter("ename");
		
		Exam exam=null;
		boolean bool=false;
		try {
			 exam =new Exam(eid, ename);
			ExamServiceImpl examServiceImpl=new ExamServiceImpl();
			bool=examServiceImpl.update(exam);
			response.sendRedirect("Exam.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void editForm(HttpServletResponse response, boolean error) throws  IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");

		out.println("<title>Edit Exam</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method =\"post\">");
		out.println("ExamId : <input type=\"text\" name=\"eid\"><br>");
		out.println("ExamName : <input type=\"text\" name=\"ename\"><br>");

		out.println("<input type=\"submit\" value=\"Submit\">");

		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
