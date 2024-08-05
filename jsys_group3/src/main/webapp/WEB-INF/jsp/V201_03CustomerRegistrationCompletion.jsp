<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>得意先登録完了</title>
	    
	    <!-- Temp.jspをinclude -->
	    <%@ include file="Temp.jsp" %>

	</head>

	<body>
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_04Navbar.jsp" %>
	
	    <div class="container mt-5 text-center">
	        <h4 class="my-5">登録が完了しました。</h4>
	        <button type="button" class="btn btn-primary" name="buttonId" value="back">登録画面へ戻る</button>
	    </div>
	
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	
	</body>
</html>
