<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>システムエラー画面</title>
	</head>
	
	<body style="text-align:center">
		
		<h2>システムエラー画面</h2>
		
		<c:out value="${requestScope.errorMessage}" />
		 
		<form action="/jsys/jsysFC" method="post">
			<button type="submit" name="buttonId" value="V901_01_01">ログイン画面へ</button>
		</form>
	
	</body>
</html>