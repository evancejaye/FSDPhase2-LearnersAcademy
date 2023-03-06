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
<title>Learner's Academy | Teachers</title>
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
		<h3>Add Teacher</h3>
		<form action="AdminController" method="post">
			First Name: <input type="text" name="fname"
				placeholder="Enter first name" required/> <br>
				 Last Name: <input
				type="text" name="lname" placeholder="Enter last name" required/> <br>
				Age: <input
				type="text" name="age" placeholder="Enter age" />
			<br> <input type="submit" value="Add Teacher" name="action" required/>
		</form>

		<table style="margin-top: 15px" border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>age</th>
				</tr>
			</thead>

			<%
			try {
				connection = DriverManager.getConnection(connectionUrl, username, password);
				statement = connection.createStatement();
				String sql = "select * from teachers";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			%>

			<tr>
				<td><%=resultSet.getInt("id")%></td>
				<td><%=resultSet.getString("fname")%></td>
				<td><%=resultSet.getString("lname")%></td>
				<td><%=resultSet.getString("age")%></td>
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