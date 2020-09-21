<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String dri = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/dxc?autoReconnect=true&relaxAutoCommit=true";
	String un = "root";
	String pw = "root";
	try {
		Class.forName(dri);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
	<center>
		<h1>Student Details</h1>
		<table border="2">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Email</td>
				<td>Mobile</td>


			</tr>
			<%
				try {
					connection = DriverManager.getConnection(url, un, pw);
					statement = connection.createStatement();
					String sql = "select * from student";
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
			%>

			<tr>

				<td><%=resultSet.getInt("id")%></td>
				<td><%=resultSet.getString("name")%></td>
				<td><%=resultSet.getString("email")%></td>
				<td><%=resultSet.getString("mobile")%></td>
         </tr>
			</center>

			<%
				}
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>

		</table>
		<br></br> <a href="AddStudent.jsp">Add New Student Details</a><br>
		<br> <a href="EdiStu">Edit Student Details</a><br> <br>
		<a href="DelStu">Delete Existing Student</a><br> <br> <a
			href="Link.jsp">Home</a>
</body>
</html>



