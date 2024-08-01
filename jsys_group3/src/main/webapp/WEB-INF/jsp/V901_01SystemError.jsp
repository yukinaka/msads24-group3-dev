<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>システムエラー</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>
</head>
<body>
    <!-- Navbar.jspをinclude -->
    <%@ include file="Navbar.jsp" %>

    <div class="container text-center mt-5">
        <h2 class="display-4">システムエラー</h2>
        
        <div class="alert alert-danger mt-4">
            <strong>システムエラーが発生しました。</strong>
        </div>
    </div>
    
    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>