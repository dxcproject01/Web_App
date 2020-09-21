<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Marks</title>
</head>
<body>
<h3>Enter Marks  below</h3>
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
				<td>Sub1</td>
				<td><input type="text" name="sub1"></td>
			</tr>
			<tr>
				<td>Sub2</td>
				<td><input type="text" name="sub2"></td>
			</tr>
			<tr>
				<td>Sub3</td>
				<td><input type="text" name="sub3"></td>
			</tr>
			<tr>
				<td>Total</td>
				<td><input type="text" name="total"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>

</body>
</html>
<%
String id=request.getParameter("id");
String name=request.getParameter("name");
String sub1=request.getParameter("sub1");
String sub2=request.getParameter("sub2");
String sub3=request.getParameter("sub3");
String total=request.getParameter("total");


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc", "root", "root");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into mark(id,name,sub1,sub2,sub3,total)values('"+id+"','"+name+"','"+sub1+"','"+sub2+"','"+sub3+"','"+total+"')");
out.println("Details are successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
<br></br>
Click <a href="Mark.jsp">here</a> to go back