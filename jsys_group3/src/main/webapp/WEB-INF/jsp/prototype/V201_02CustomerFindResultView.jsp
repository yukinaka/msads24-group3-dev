<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>従業員検索結果</title>
	</head>
	
	<body style="text-align: center">
		<h2>得意先検索結果</h2>
		
		<table border="1" style="margin: 0 auto;">
			<tr>
				<td>得意先コード</td>
				<td><c:out value="${ requestScope.customer.custCode }"></c:out></td>
			</tr>
			<tr>
				<td>得意先名</td>
				<td><c:out value="${ requestScope.customer.custName }"></c:out></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><c:out value="${ requestScope.customer.telNo }"></c:out></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><c:out value="${ requestScope.customer.postalCode }"></c:out></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><c:out value="${ requestScope.customer.address }"></c:out></td>
			</tr>
			<tr>
				<td>割引率</td>
				<td><c:out value="${ requestScope.customer.discountRate }"></c:out></td>
			</tr>
		</table>
		
		<form action="/jsys/jsysFC" method="post">
			<button type="submit" name="buttonId" value="V201_02_01">前画面へ戻る</button><br>
		</form>
		
	</body>
	
</html>