<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	document.getElementById("myForm").reset();
</script>
</head>
<body>

	<form method="post" action="join.do" id="myForm">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<table>
				<tr>
					<td>User name</td>
					<td><input type="text" placeholder="Enter UserName"
						name="uname"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="uemail"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name=upass></td>
				</tr>
			</table>

			<input type="submit" value="Register">
		</div>

	</form>

</body>
</html>