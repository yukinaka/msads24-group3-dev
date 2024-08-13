<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>得意先変更完了</title>
	
	<!-- Temp.jspをinclude -->
	<%@ include file="Temp.jsp" %>
	
	</head>
	
	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_04Navbar.jsp" %>
		
		<div class="container mt-5 text-center">
	        <h4 class="my-5">変更が完了しました。</h4>
	        
	        <form action="/jsys_group3/jsysFC" method="post">
	        	<button type="submit" class="btn btn-primary" name="buttonId" value="V222_03_01">得意先一覧画面へ戻る</button>
	        </form>
	        
	    </div>
		
		<!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>