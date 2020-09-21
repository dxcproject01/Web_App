<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Student</title>
</head>
<body>

	<h3>Enter student details below</h3>
	<form method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name">
				<td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form>

</body>
</html>
<%
String id=request.getParameter("id");
String name=request.getParameter("name");
String email=request.getParameter("email");
String mobile=request.getParameter("mobile");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc", "root", "root");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into student(id,name,email,mobile)values('"+id+"','"+name+"','"+email+"','"+mobile+"')");
out.println("Details are successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
<br></br>
<h4>Click <a href="Stud.jsp">here</a> to go back</h4>