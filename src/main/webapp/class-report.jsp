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
String classId = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learner's Academy | Class Report</title>
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
		<h3>Class Report</h3>
		

		<table style="margin-top: 15px" border="1">
			<thead>
				<tr>
					<th>class Id</th>
					<th>Subjects</th>
					<th>Teachers</th>
					<th>Students</th>
				</tr>
			</thead>

		

			<tr>
				<td><%=classId%></td>
				<td>
				
					<%
			try {
				connection = DriverManager.getConnection(connectionUrl, username, password);
				statement = connection.createStatement();
				String sql = "select s.name  from classes c , subjects s where c.id = "+classId + " and s.id=c.subject";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			%>
			
				<%= resultSet.getString("name") %> 
				
				
					<%
				}
				connection.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
				
				</td>
				
				<td>
				
			
				
					<%
			try {
				connection = DriverManager.getConnection(connectionUrl, username, password);
				statement = connection.createStatement();
				String sql = "select t.fname , t.lname from classes c , teachers t where c.id = "+classId + " and c.teacher=t.id";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			%>
			
				<%= resultSet.getString("fname") %> <%= resultSet.getString("lname") %> 
				
				
					<%
				}
				connection.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
	
				</td>
				
				<td>
				<ul>
					<%
			try {
				connection = DriverManager.getConnection(connectionUrl, username, password);
				statement = connection.createStatement();
				String sql = "select fname , lname from students  where class = "+classId;
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			%>
			
				<li><%= resultSet.getString("fname") %> <%= resultSet.getString("lname") %> </li>
				
				
					<%
				}
				connection.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
				</ul>
				</td>
				
				

			</tr>
		

		</table>


	</div>

</body>
</html>