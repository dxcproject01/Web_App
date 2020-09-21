<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Exam Details</h1>
		<table border="2">
			<tr>
				<td>Exam Id</td>
				<td>Exam Name</td>
				
				</tr>
			<%
				try {
					connection = DriverManager.getConnection(url, un, pw);
					statement = connection.createStatement();
					String sql = "select * from exam";
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
			%>
			
			<tr>
				<td><%=resultSet.getInt("eid")%></td>
				<td><%=resultSet.getString("ename")%></td>
				
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
		<br></br>
		<a href="AddExam.jsp">Add New Exam Details</a><br>
		<br>
		<a href="EdiExam">Edit Exam Details</a><br>
		<br>
		<a href="DelExam">Delete Exam</a><br>
		<br>
		<a href="Link.jsp">Home</a>
</body>
</html>