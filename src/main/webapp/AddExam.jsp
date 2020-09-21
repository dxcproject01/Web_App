<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Exam</title>
</head>
<body>
	<h3>Enter Exam below</h3>
	<form method="post">
		<table>
			<tr>
				<td>ExamId</td>
				<td><input type="text" name="eid"></td>
			</tr>
			<tr>
				<td>ExamName</td>
				<td><input type="text" name="ename">
				<td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
</body>

</html>

<%
	String eid = request.getParameter("eid");
	String ename = request.getParameter("ename");

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc", "root", "root");
		Statement st = conn.createStatement();

		int i = st.executeUpdate("insert into exam(eid,ename)values('" + eid + "','" + ename + "')");
		out.println("Details are successfully inserted!");
	} catch (Exception e) {
		System.out.print(e);
		e.printStackTrace();
	}
%>
<br></br>

	Click <a href="Exam.jsp">here</a> to go back

