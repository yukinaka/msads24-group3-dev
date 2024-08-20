<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_01Navbar.jsp" %>
	
		<!-- メインコンテンツ -->
	    <div class="container mt-5">
	        <h2 class="text-center">ログイン</h2>
	        
     		<%-- エラーメッセージがある場合、出力 --%>
	     	<h4 class="text-center text-danger mb-3">
				<c:out value="${requestScope.errorMessage}"/>
				<c:forEach var="message" items="${requestScope.errorMessageList}">
					<c:out value="${message}"/><br>
				</c:forEach>
	     	</h4>
	        
	        <form action="/jsys_group3/jsysFC" method="post">
	            <div class="mb-3">
	                <label for="username" class="form-label">従業員番号</label>
	                <input type="text" class="form-control" id="username" name="empNo" title="従業員番号を入力してください。" required value="<c:out value="${ param.empId }" />">
	            </div>
	            <div class="mb-3">
	                <label for="password" class="form-label">パスワード</label>
	                <input type="password" class="form-control" id="password" name="password" title="パスワードを入力してください。" required value="<c:out value="${ param.password }" />">
	            </div>
	            <button type="submit" class="btn btn-primary w-100" name="buttonId" value="V101_01_01">ログイン</button>
	        </form>
	    </div>
	    
	   <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>