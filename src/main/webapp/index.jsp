<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learner's Academy | Admin Login</title>
</head>
<body>

	<div>
	<h3>Admin login</h3>
		<form action="AdminController" method="post">
			Username: <input type="text" name="username" placeholder="Enter username" /> <br>
			Password : <input type="password" name="password" placeholder="Enter password" /> <br>
			<input type="submit" value="Login" name="action" />
		</form>
	</div>

</body>
</html>