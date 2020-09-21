package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.beans.Mark;

import com.dxc.service.MarkServiceImpl;


/**
 * Servlet implementation class EdiMark
 */
public class EdiMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdiMark() {
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
         
        String sub1=request.getParameter("sub1");  
        String sub2=request.getParameter("sub2");
        String sub3=request.getParameter("sub3");
        String total=request.getParameter("total");
        
          
        Mark mark = new Mark(id, name, sub1, sub2, sub3, total);
        mark.setId(id);  
        mark.setName(name);  
        mark.setSub1(sub1); 
        mark.setSub2(sub2);
        mark.setSub3(sub3);
        mark.setTotal(total);
          
        MarkServiceImpl markServiceImpl = new MarkServiceImpl(); 
        boolean boolea=markServiceImpl.update(mark);
        response.sendRedirect("Mark.jsp");

          
        out.close();
	}
	
	protected void editForm(HttpServletResponse response, boolean error) throws  IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");

		out.println("<title>Edit Student Marks</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method =\"post\">");
		out.println("Id : <input type=\"text\" name=\"id\"><br>");
		out.println("Name : <input type=\"text\" name=\"name\"><br>");
		out.println("Subject1 : <input type=\"text\" name=\"sub1\"><br>");
		out.println("Subject2 : <input type=\"text\" name=\"sub2\"><br>");
		out.println("Subject3 : <input type=\"text\" name=\"sub3\"><br>");
		out.println("Total : <input type=\"text\" name=\"total\"><br>");
		
		out.println("<input type=\"submit\" value=\"Submit\">");
		
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
