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
		<%@ include file="Navbar.jsp" %>
	
		<!-- メインコンテンツ -->
	    <div class="container">
	        <div class="main-menu-container">
	            <h2 class="text-center mb-3">メインメニュー</h2>
	            <div class="d-flex justify-content-center flex-column align-items-center">
	            	<div class="mb-3">
		                <a href="managementPage.jsp" class="btn btn-primary btn-lg mb-3">管理</a>
	                </div>
	                <div class="mb-3">
		                <a href="listPage.jsp" class="btn btn-primary btn-lg">集計</a>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	   <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>