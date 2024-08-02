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
	        <p class="lead">ログアウトしました。</p>
	        
	        <form action="/jsys/jsysFC" method="post">
	            <button type="submit" class="btn btn-primary" name="buttonId" value="99">ログイン画面へ戻る</button>
	        </form>
	    </div>
	    
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	    
	</body>
</html>