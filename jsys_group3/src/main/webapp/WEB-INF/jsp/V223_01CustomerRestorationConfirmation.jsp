<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先復元確認</title>
	    
	    <%@ include file="Temp.jsp" %>
	    
	</head>

	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container text-center mt-5">
		    <h2>得意先復元確認</h2>
		    <p class="mt-3">以下の得意先を復元します。よろしいですか？</p>
		
		    <table class="table table-bordered table-striped text-start w-50 mx-auto">
		        <tbody>
		            <tr>
		                <th scope="row">得意先名</th>
		                <td><c:out value="${ requestScope.customer.custName }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号1</th>
		                <td><c:out value="${ requestScope.customer.telNo1 }" /></td>
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
		                <td><c:out value="${ requestScope.customer.address1 }" /></td>
		            </tr>
		             <tr>
		                <th scope="row">郵便番号2</th>
		                <td><c:out value="${ requestScope.customer.postalCode2 }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">住所2</th>
		                <td><c:out value="${ requestScope.customer.address2 }" /></td>
		            </tr>
		            <tr>
		                <th scope="row">割引率</th>
		                <td><c:out value="${ requestScope.customer.discountRate }" />%</td>
		            </tr>
		        </tbody>
		    </table>
		    
		    <form action="/jsys_group3/jsysFC" method="post">
				<input type="hidden" name="custCode" value="<c:out value="${ customer.custCode }" />">
                <input type="hidden" name="custName" value="<c:out value="${ customer.custName }" />">
		 		<input type="hidden" name="telNo1" value="<c:out value="${ customer.telNo1 }" />">
		 		<input type="hidden" name="telNo2" value="<c:out value="${ customer.telNo2 }" />">
		 		<input type="hidden" name="telNo3" value="<c:out value="${ customer.telNo3 }" />">
		 		<input type="hidden" name="postalCode1" value="<c:out value="${ customer.postalCode1 }" />">
		 		<input type="hidden" name="address1" value="<c:out value="${ customer.address1 }" />">
		 		<input type="hidden" name="postalCode2" value="<c:out value="${ customer.postalCode2 }" />">
		 		<input type="hidden" name="address2" value="<c:out value="${ customer.address2 }" />">
		 		<input type="hidden" name="discountRate" value="<c:out value="${ customer.discountRate }" />">
		 		<input type="hidden" name="deleteFlag" value="<c:out value="${ customer.deleteFlag }" />">
		 		<input type="hidden" name="lastUpdateBy" value="<c:out value="${ customer.lastUpdateBy }" />">
			    <div class="mt-3">
			        <button type="submit" class="btn btn-success mr-2" name="buttonId" value="V223_01_01">はい</button>
			        <button type="submit" class="btn btn-secondary" name="buttonId" value="V223_01_02">キャンセル</button>
			    </div>
		    </form>
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>
