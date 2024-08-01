<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
	
		<!-- LoginNavbar.jspをinclude -->
		<%@ include file="LoginNavbar.jsp" %>
	
		<!-- メインコンテンツ -->
	    <div class="container">
	        <div class="login-container">
	            <h2 class="text-center">ログイン</h2>
	            
	            <div style="text-align: center; color: red;">
		        	<h4>エラーメッセージエリア</h4>
		        </div> 
	            
	            <form action="loginServlet" method="post">
	                <div class="mb-3">
	                    <label for="username" class="form-label">従業員番号</label>
	                    <input type="text" class="form-control" id="username" name="username" required>
	                </div>
	                <div class="mb-3">
	                    <label for="password" class="form-label">パスワード</label>
	                    <input type="password" class="form-control" id="password" name="password" required>
	                </div>
	                <button type="submit" class="btn btn-primary w-100">ログイン</button>
	            </form>
	        </div>
	    </div>
	    
	   <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>