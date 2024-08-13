<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>得意先詳細情報</title>
	    
	    <!-- Temp.jspをinclude -->
	    <%@ include file="Temp.jsp" %>
	    
	</head>
	
	<body>
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_03Navbar.jsp" %>
	
	    <div class="container mt-5">
	        <h2 class="text-center mb-4">得意先詳細情報</h2>
	        
	        <div class="row justify-content-center">
	            <div class="col-md-8">
	                <table class="table table-bordered table-striped">
	                    <tbody>
	                    
	                        <tr>
	                            <th scope="row">得意先コード</th>
	                            <td><c:out value="${ requestScope.customer.custCode }"/></td>
	                        </tr>
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
	                        </tr>
	                        <tr>
	                            <th scope="row">住所2</th>
	                            <td><c:out value="${ requestScope.customer.address2 }"/></td>
	                        </tr>
	                        <tr>
	                            <th scope="row">割引率</th>
	                            <td class="text-start"><c:out value="${ requestScope.customer.discountRate }"/>%</td>
	                        </tr>
	                        <tr>
	                            <th scope="row">最終更新者</th>
	                            <td><c:out value="${ requestScope.customer.lastUpdateBy }"/></td>
	                        </tr>
	                    </tbody>
	                </table>
	
	                <div class="text-center mt-4">
	                    <form action="/jsys_group3/jsysFC" method="post">
	                    
		                    <input type="hidden" name="custCode" value="<c:out value="${ requestScope.customer.custCode }" />">
		                    <input type="hidden" name="custName" value="<c:out value="${ requestScope.customer.custName }" />">
					 		<input type="hidden" name="telNo1" value="<c:out value="${ requestScope.customer.telNo1 }" />">
					 		<input type="hidden" name="telNo2" value="<c:out value="${ requestScope.customer.telNo2 }" />">
					 		<input type="hidden" name="telNo3" value="<c:out value="${ requestScope.customer.telNo3 }" />">
					 		<input type="hidden" name="postalCode1" value="<c:out value="${ requestScope.customer.postalCode1 }" />">
					 		<input type="hidden" name="address1" value="<c:out value="${ requestScope.customer.address1 }" />">
					 		<input type="hidden" name="postalCode2" value="<c:out value="${ requestScope.customer.postalCode2 }" />">
					 		<input type="hidden" name="address2" value="<c:out value="${ requestScope.customer.address2 }" />">
					 		<input type="hidden" name="discountRate" value="<c:out value="${ requestScope.customer.discountRate }" />">
					 		<input type="hidden" name="deleteFlag" value="<c:out value="${ requestScope.customer.deleteFlag }" />">
					 		<input type="hidden" name="lastUpdateBy" value="<c:out value="${ requestScope.customer.lastUpdateBy }" />">
		 		
		 		
	                        <button type="submit" class="btn btn-secondary mr-2" name="buttonId" value="V211_01_01">前画面へ戻る</button>
	                        <button type="submit" class="btn btn-primary mr-2" name="buttonId" value="V211_01_02">変更</button>
	                        <c:if test="${ requestScope.customer.deleteFlag == false }">
		                        <button type="submit" class="btn btn-danger" name="buttonId" value="V211_01_03">削除</button>
	                        </c:if>
	                        <c:if test="${ requestScope.customer.deleteFlag == true }">
		                        <button type="submit" class="btn btn-success" name="buttonId" value="V211_01_04">復元</button>
	                        </c:if>
	                        
	                        
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	    
	</body>
</html>