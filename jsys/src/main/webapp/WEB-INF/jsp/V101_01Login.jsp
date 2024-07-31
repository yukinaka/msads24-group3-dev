<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン画面</title>
	</head>
	
	<body style="text-align: center">
		<h2>ログイン画面</h2>
		
		<form action="/jsys/jsysFC" method="post">
			従業員番号<input type="text" name="employeeId" value="<c:out value="${ param.employeeId }"></c:out>"><br>
			パスワード<input type="password" name="password"><br>
			<button type="submit" name="buttonId" value="V101_01_01">ログイン</button><br>
		</form>
		
	</body>
</html>