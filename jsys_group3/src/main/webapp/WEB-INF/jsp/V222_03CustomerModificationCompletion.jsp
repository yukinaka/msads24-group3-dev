<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>得意先変更完了</title>

<!-- Bootstrap CSS CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

<!-- Temp.jspをinclude -->
<%@ include file="Temp.jsp" %>

</head>
<body>

<!-- Navbar.jspをinclude -->
<%@ include file="V400_04Navbar.jsp" %>

<div class="container d-flex flex-column justify-content-center align-items-center min-vh-100 mt-5">
  <div class="text-center">
    <h2 class="mb-4">変更が完了しました。</h2>
    <a href="previousPage.jsp" class="btn btn-primary">得意先一覧へ戻る</a>
  </div>
</div>

<!-- Footer.jspをinclude -->
<%@ include file="Footer.jsp" %>

<!-- Bootstrap JS and dependencies (optional) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
