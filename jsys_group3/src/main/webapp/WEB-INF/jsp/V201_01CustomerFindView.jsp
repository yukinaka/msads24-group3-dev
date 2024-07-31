<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>得意先検索</title>
	</head>
	
	<body style="text-align: center">
		<h2>得意先検索</h2>
		
		<div style="text-align: right">
			<form action="/jsys/jsysFC" method="post">
				<button type="submit" name="buttonId" value="V201_01_01">メニュー画面に戻る</button><br>
			</form>
		</div>
		
		<div style="color: red; font-weight: bold">
			<c:out value="${ requestScope.errorMessage }"></c:out>
			<c:forEach var="message" items="${ requestScope.errorMessageList }">
				<c:out value="${ message }"></c:out><br>
			</c:forEach>
		</div>
		
		<form action="/jsys/jsysFC" method="post">
			得意先コード<input type="text" name="custCode" value="<c:out value="${ param.custCode }"></c:out>"><br>
			<button type="submit" name="buttonId" value="V201_01_02">検索</button><br>
		</form>
		
	</body>
</html>