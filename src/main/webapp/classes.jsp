<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.academy.util.Constants"%>
<%
String driver = Constants.DRIVER_NAME;
String connectionUrl = Constants.URL;
String username = Constants.USERNAME;
String password = Constants.PASSWORD;
try {
	Class.forName(driver);
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
<meta charset="UTF-8">
<title>Learner's Academy | Classes</title>
</head>
<body>

	<h1>Admin Home</h1>

	<div>
		<a href="students.jsp">Students</a> 
		<a href="subjects.jsp">Subjects</a> 
		<a href="classes.jsp">Classes</a>
		<a href="teachers.jsp">Teachers</a>
		<form action="AdminController" method="post">
			<input type="submit" name="action" value="Logout" />
		</form>
	</div>

	<div>
		<h3>Add Class</h3>
		<form action="AdminController" method="post">
			Section: <input type="text" name="section"
				placeholder="Enter Section id" required /> <br>
				 Teacher: <select name="teacher" required>
				 
				 <%
				try {
					connection = DriverManager.getConnection(connectionUrl, username, password);
					statement = connection.createStatement();
					String sql = "select * from teachers";
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
				%>
				 	<option value="<%=resultSet.getInt("id")%>"><%=resultSet.getString("fname")%> <%=resultSet.getString("lname")%></option>
				
					<%
				}
				connection.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
				
				
				 </select> <br>
				 
				  Subject: <select name="subject" required>
				  
				   <%
				try {
					connection = DriverManager.getConnection(connectionUrl, username, password);
					statement = connection.createStatement();
					String sql = "select * from subjects";
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
				%>
				  
				  
				 	<option value="<%=resultSet.getInt("id")%>"><%=resultSet.getString("name")%></option>
				 	
				 		<%
				}
				connection.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
				 	
				 	
				 </select> <br>
				 
				 Time: <input type="time" name="time" /> <br>
			
			 <input type="submit" value="Add Class" name="action" />
		</form>

		<table style="margin-top: 15px" border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>Section</th>
					<th>Teacher</th>
					<th>Subject</th>
					<th>Time</th>
					<th>View report</th>
				</tr>
			</thead>

			<%
			try {
				connection = DriverManager.getConnection(connectionUrl, username, password);
				statement = connection.createStatement();
				String sql = "select c.id , c.section , c.time, t.fname , t.lname , s.name from teachers t , subjects s , classes c where t.id = c.teacher and s.id = c.subject";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			%>

			<tr>
				<td><%=resultSet.getInt("id")%></td>
				<td><%=resultSet.getInt("section")%></td>
				<td><%=resultSet.getString("fname")%> <%=resultSet.getString("lname")%></td>
				<td><%=resultSet.getString("name")%></td>
				<td><%=resultSet.getString("time")%></td>
				<td> <a href="class-report.jsp?id=<%=resultSet.getInt("id")%>">class report</a> </td>
			</tr>
			<%
				}
				connection.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>

		</table>


	</div>

</body>
</html>