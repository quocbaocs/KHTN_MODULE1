<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>page list</h1>
	<a style="padding: 15px 20px; background: red;" href="join.do">Add</a>
	<div style="display: flex; justify-content: center;">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${userList}">
					<tr>

						<td>${vo.uid}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
						<td>${vo.passwd}</td>
					</tr>
				</c:forEach>



			</tbody>
		</table>
	</div>

</body>
</html>