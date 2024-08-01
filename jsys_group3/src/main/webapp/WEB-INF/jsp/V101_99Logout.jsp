<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログアウト</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>
</head>
<body>
    <!-- Navbar.jspをinclude -->
    <%@ include file="Navbar.jsp" %>

    <div class="container text-center">
        <h2 class="my-4">ログアウト</h2>
        
        <p class="lead">ログアウトしました。</p>
        
        <form action="/jsys/jsysFC" method="post">
            <button type="submit" class="btn btn-primary" name="buttonId" value="99">ログイン画面へ戻る</button>
        </form>
    </div>
    
    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>