<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>得意先変更確認</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
	
	</head>
	
	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
	
		<div class="container text-center mt-5">
			<h2>得意先変更確認</h2>
			<p class="mt-3">得意先の情報を以下の情報に変更します。よろしいですか？</p>
			
			<table class="table table-bordered table-striped text-start w-50 mx-auto">
		        <tbody>
		            <tr>
		                <th scope="row">得意先名</th>
		                <td><c:out value="${ requestScope.customer.custName }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号1</th>
		                <td><c:out value="${ requestScope.customer.telNo1 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号2</th>
		                <td><c:out value="${ requestScope.customer.telNo2 }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号3</th>
		                <td><c:out value="${ requestScope.customer.telNo3 }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号1</th>
						<td><c:out value="${ requestScope.customer.postalCode1 }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">住所1</th>
						<td><c:out value="${ requestScope.customer.address1 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号2</th>
						<td><c:out value="${ requestScope.customer.postalCode2 }" /></td>
		            <tr>
		                <th scope="row">住所2</th>
						<td><c:out value="${ requestScope.customer.address2 }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">割引率</th>
					 	<td><c:out value="${ requestScope.customer.discountRate }" /></td>
		            </tr>
		        </tbody>
		    </table>
		 
					    
		    <div class="mt-3">
		    	<button class="btn btn-primary" name="buttonId" value="V222_02_01">はい</button>
		    	<button class="btn btn-secondary" name="buttonId" value="V222_02_02">キャンセル</button>
			</div>
			
	<!-- Footer.jspをinclude -->
	<%@ include file="Footer.jsp" %>
	
	</body>
</html>