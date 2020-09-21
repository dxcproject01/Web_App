package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.service.MarkServiceImpl;
import com.dxc.service.StudentServiceImpl;

/**
 * Servlet implementation class DelMark
 */
public class DelMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMark() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		boolean boolea = false;
		try {
			MarkServiceImpl markServiceImpl = new MarkServiceImpl();
			boolea=markServiceImpl.delete(id);
			response.sendRedirect("Mark.jsp");
			
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

		out.println("<title>Delete Student</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method =\"post\">");
		out.println("Enter Id to delete : <input type=\"text\" name=\"id\"><br>");


		out.println("<input type=\"submit\" value=\"Submit\">");

		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
