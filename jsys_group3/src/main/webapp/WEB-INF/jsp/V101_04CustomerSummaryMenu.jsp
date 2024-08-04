<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	    <meta charset="UTF-8">
	    <title>得意先別集計メニュー</title>
	
	    <%@ include file="Temp.jsp" %>
	</head>
	
	<body>
	    <!-- Navbar.jspをinclude -->
	    <%@ include file="V400_05Navbar.jsp" %>
	    
	    <div class="container text-center mt-5">
	        <h2 class="my-4">得意先別集計メニュー</h2>
	
	        <div class="btn-group-vertical">
	            <button type="button" class="btn btn-info my-2">期間内受注集計</button>
	            <button type="button" class="btn btn-info my-2">商品別受注集計</button>
	        </div>
	    </div>
	    
	    <!-- Footer.jspをinclude -->
	    <%@ include file="Footer.jsp" %>
	
	</body>
</html>
