<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録完了</title>
    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>
    <!-- Bootstrap CSSを追加 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navbar.jspをinclude -->
    <%@ include file="V400_04Navbar.jsp" %>

    <div class="container mt-5 text-center">
        <h2>登録が完了しました。</h2>
        <br>
        <a href="戻るリンク先" class="btn btn-primary">登録画面へ戻る</a>
    </div>

    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>

    <!-- Bootstrap JSと依存するPopper.jsとjQueryを追加 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
