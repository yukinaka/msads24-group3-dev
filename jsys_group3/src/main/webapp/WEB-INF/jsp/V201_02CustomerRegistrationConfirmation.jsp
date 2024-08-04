<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>得意先登録確認</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container text-center mt-5">
			<h2>得意先登録確認</h2>
			<p class="mt-3">以下の得意先を登録します。よろしいですか？</p>
			
			<table class="table table-bordered table-striped text-start w-50 mx-auto">
		        <tbody>
		            <tr>
		                <th scope="row">得意先名</th>
		                <td>Aストア</td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号1</th>
		                <td><c:out value="${ requestScope.customer.phone1 }" default = "045-128-3581"/></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号2</th>
		                <td><c:out value="${ requestScope.customer.phone2 }" default = "045-128-3582"/></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号3</th>
		                <td><c:out value="${ requestScope.customer.phone3 }" default = "045-128-3583"/></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号1</th>
						<td><c:out value="${ requestScope.customer.postalCode1 }" default = "220-0001"/></td>
		            </tr>
		            <tr>
		                <th scope="row">住所1</th>
						<td><c:out value="${ requestScope.customer.address1 }" default = "横浜市西区北幸２－１"/></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号2</th>
						<td><c:out value="${ requestScope.customer.postalCode2 }" default = "220-0002"/></td>
		            <tr>
		                <th scope="row">住所2</th>
						<td><c:out value="${ requestScope.customer.address2 }" default = "横浜市西区北幸２－２"/></td>
		            </tr>
		            <tr>
		                <th scope="row">割引率</th>
					 	<td><c:out value="${ requestScope.customer.discountRate }" default = "0%"/></td>
		            </tr>
		        </tbody>
		    </table>
		 
					    
		    <div class="mt-3">
		    	<button class="btn btn-primary">はい</button>
		    	<button class="btn btn-secondary">キャンセル</button>
			</div>
					  
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>
