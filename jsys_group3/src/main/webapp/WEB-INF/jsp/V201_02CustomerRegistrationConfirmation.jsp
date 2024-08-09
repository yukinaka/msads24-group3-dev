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
		                <td><c:out value="${ requestScope.customer.custName }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号1</th>
		                <td><c:out value="${ requestScope.customer.telNo1 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号2</th>
		                <td><c:out value="${ requestScope.customer.telNo2 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号3</th>
		                <td><c:out value="${ requestScope.customer.telNo3 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号1</th>
						<td><c:out value="${ requestScope.customer.postalCode1 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">住所1</th>
						<td><c:out value="${ requestScope.customer.address1 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号2</th>
						<td><c:out value="${ requestScope.customer.postalCode2 }"/></td>
		            <tr>
		                <th scope="row">住所2</th>
						<td><c:out value="${ requestScope.customer.address2 }"/></td>
		            </tr>
		            <tr>
		                <th scope="row">割引率</th>
					 	<td><c:out value="${ requestScope.customer.discountRate }" />%</td>
		            </tr>
		        </tbody>
		    </table>
		 
		 	<form action="/jsys_group3/jsysFC" method="post">
		 		<input type="hidden" name="custName" value="<c:out value="${ requestScope.customer.custName }" />">
		 		<input type="hidden" name="telNo1" value="<c:out value="${ requestScope.customer.telNo1 }" />">
		 		<input type="hidden" name="telNo2" value="<c:out value="${ requestScope.customer.telNo2 }" />">
		 		<input type="hidden" name="telNo3" value="<c:out value="${ requestScope.customer.telNo3 }" />">
		 		<input type="hidden" name="postalCode1" value="<c:out value="${ requestScope.customer.postalCode1 }" />">
		 		<input type="hidden" name="address1" value="<c:out value="${ requestScope.customer.address1 }" />">
		 		<input type="hidden" name="postalCode2" value="<c:out value="${ requestScope.customer.postalCode2 }" />">
		 		<input type="hidden" name="address2" value="<c:out value="${ requestScope.customer.address2 }" />">
		 		<input type="hidden" name="discountRate" value="<c:out value="${ requestScope.customer.discountRate }" />">
		 		
	            <div class="mt-3">
			    	<button class="btn btn-primary" name="buttonId" value="V201_02_01">はい</button>
			    	<button class="btn btn-secondary" name="buttonId" value="V201_02_02">キャンセル</button>
				</div>
				
	        </form>
					    
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>
