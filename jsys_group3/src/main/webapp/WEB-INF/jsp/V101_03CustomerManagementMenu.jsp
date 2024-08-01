<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得意先管理メニュー</title>
    <!-- Bootstrap CSSを追加 -->
    <%@ include file="Temp.jsp" %>
</head>
<body>

    <!-- Navbar.jspをinclude -->
    <%@ include file="Navbar.jsp" %>

    <div class="container text-center">
        <h2 class="my-4">得意先管理メニュー</h2>

        <div class="btn-group-vertical">
            <button type="button" class="btn btn-primary my-2">登録</button>
            <button type="button" class="btn btn-secondary my-2">一覧</button>
        </div>
    </div>
    
    <br>

    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>

    <!-- Bootstrap JS, Popper.js, and jQueryを追加 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
