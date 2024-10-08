<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先削除確認</title>
	    
	    <!-- Bootstrap CSSを追加 -->
	    <%@ include file="Temp.jsp" %>
	    
	</head>

	<body>	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container text-center mt-5">
		    <h2>得意先削除確認</h2>
		    <p class="mt-3">以下の得意先を削除します。よろしいですか？</p>
		
		    <table class="table table-bordered table-striped text-start w-50 mx-auto">
		        <tbody>
		            <tr>
		                <th scope="row">得意先名</th>
		                <td><c:out value="${ requestScope.customer.custName }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号1</th>
		                <td><c:out value="${ requestScope.customer.telNo1 }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号2</th>
		                <td><c:out value="${ requestScope.customer.telNo2 }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">電話番号3</th>
		                <td><c:out value="${ requestScope.customer.telNo3 }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号1</th>
		                <td><c:out value="${ requestScope.customer.postalCode1 }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">住所1</th>
		                <td><c:out value="${ requestScope.customer.address1 }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">郵便番号2</th>
		                <td><c:out value="${ requestScope.customer.postalCode2 }"></c:out></td>
		            <tr>
		                <th scope="row">住所2</th>
		                <td><c:out value="${ requestScope.customer.address2 }"></c:out></td>
		            </tr>
		            <tr>
		                <th scope="row">割引率</th>
		                <td><c:out value="${ requestScope.customer.discountRate }">%</c:out></td>
		            </tr>
		        </tbody>
		    </table>
		
			<form action="/jsys_group3/jsysFC" method="post">
		    	<div class="mt-3">
		        	<button type="button" class="btn btn-danger mr-2" name="buttonId" value="V221_01_01">はい</button>
		        	<button type="button" class="btn btn-secondary" name="buttonId" value="V221_01_02">キャンセル</button>
		    	</div>
		    </form>
		</div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>

	</body>
</html>
