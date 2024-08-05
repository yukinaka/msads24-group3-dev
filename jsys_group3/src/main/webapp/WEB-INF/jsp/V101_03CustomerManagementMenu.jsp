<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先管理メニュー</title>
	    
	    <!-- Temp.jspをinclude -->
	    <%@ include file="Temp.jsp" %>
	    
	</head>
	
	<body>
	
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_03Navbar.jsp" %>
	
	    <div class="container text-center mt-5">
	        <h2 class="my-4">得意先管理メニュー</h2>
	
	        <div class="btn-group-vertical">
	            <button type="button" class="btn btn-info my-2">登録</button>
	            <button type="button" class="btn btn-info my-2">一覧</button>
	        </div>
	 	</div>
	    
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	
	</body>
</html>
