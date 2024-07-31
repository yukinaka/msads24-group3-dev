<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>削除完了画面</title>
    <!-- Bootstrap CSSを追加 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="Temp.jsp" %>
</head>
<body>

<!-- Navbar.jspをinclude -->
<%@ include file="Navbar.jsp" %>

<div class="container text-center mt-5">
    <h3 class="my-5">削除が完了しました。</h3>
    <button type="button" class="btn btn-primary" name="buttonId" value="back">戻る</button>
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
