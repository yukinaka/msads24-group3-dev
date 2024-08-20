<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>ログアウト</title>
	    
	    <!-- Temp.jspをinclude -->
	    <%@ include file="Temp.jsp" %>
	    
	</head>
	
	<body>
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_01Navbar.jsp" %>
	
	    <div class="container text-center mt-5">
	        <h2 class="my-4">ログアウト</h2>
	        <%-- エラーメッセージがある場合、出力 --%>
	     	<h4 class="text-center text-danger mb-3">
				<c:out value="${requestScope.errorMessage}"/>
				<c:forEach var="message" items="${requestScope.errorMessageList}">
					<c:out value="${message}"/><br>
				</c:forEach>
	     	</h4> 
	        <p class="lead">ログアウトしました。</p>
	        
	        <form action="/jsys_group3/jsysFC" method="post">
	            <button type="submit" class="btn btn-primary" name="buttonId" value="V101_99_01">ログイン画面へ戻る</button>
	        </form>
	    </div>
	    
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	    
	</body>
</html>