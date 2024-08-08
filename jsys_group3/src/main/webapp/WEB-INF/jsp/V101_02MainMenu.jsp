<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>メインメニュー画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
		<!-- Navbar.jspをinclude -->
		<%@ include file="V400_02Navbar.jsp" %>
	
		<!-- メインコンテンツ -->
	    <div class="container text-center mt-5">
            <h2 class="my-4">メインメニュー</h2>

			<form action="/jsys_group3/jsysFC" method="post">
		        <div class="btn-group-vertical">
		            <button type="submit" class="btn btn-info my-2" name="buttonId" value="V101_02_01">得意先管理</button>
		            <button type="submit" class="btn btn-info my-2" name="buttonId" value="V101_02_02">得意先別集計</button>
		        </div>
		    </form>
		    
	    </div>
	    
	    <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>