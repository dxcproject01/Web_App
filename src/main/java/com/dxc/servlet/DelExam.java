package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.service.ExamServiceImpl;
import com.dxc.service.StudentServiceImpl;

/**
 * Servlet implementation class DelExam
 */
public class DelExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deleteForm(response,false);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid=Integer.parseInt(request.getParameter("eid"));
		boolean boolea = false;
		try {
			ExamServiceImpl examServiceImpl = new ExamServiceImpl();
			boolea=examServiceImpl.delete(eid);
			response.sendRedirect("Exam.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void deleteForm(HttpServletResponse response, boolean error) throws  IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");

		out.println("<title>Delete Exam</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method =\"post\">");
		out.println("Enter Exan Id to delete : <input type=\"text\" name=\"eid\"><br>");


		out.println("<input type=\"submit\" value=\"Submit\">");

		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
