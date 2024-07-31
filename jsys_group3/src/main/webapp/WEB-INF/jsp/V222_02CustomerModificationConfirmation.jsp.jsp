<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>得意先変更確認</title>

<!-- Bootstrap CSS CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

<!-- Temp.jspをinclude -->
<%@ include file="Temp.jsp" %>

</head>
<body>

<!-- Navbar.jspをinclude -->
<%@ include file="Navbar.jsp" %>

<div class="container mt-5">
  <h2 class="text-center">得意先変更確認</h2>
  <div class="text-center mt-3">
    <p>得意先の情報を以下の情報に変更します。よろしいですか？</p>
  </div>

  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="table-responsive">
        <table class="table table-bordered table-striped">
          <tbody>
            <tr>
              <th>得意先名</th>
              <td>Aストア</td>
            </tr>
            <tr>
              <th>電話番号</th>
              <td>0451283581</td>
            </tr>
            <tr>
              <th>郵便番号</th>
              <td>2200001</td>
            </tr>
            <tr>
              <th>住所</th>
              <td>横浜市西区北幸2-1</td>
            </tr>
            <tr>
              <th>割引率</th>
              <td>0</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <div class="text-center mt-4">
    <form action="submitPage.jsp" method="post" class="d-inline">
      <button type="submit" class="btn btn-primary">はい</button>
    </form>
    <a href="cancelPage.jsp" class="btn btn-secondary">キャンセル</a>
  </div>
</div>

<!-- Footer.jspをinclude -->
<%@ include file="Footer.jsp" %>

<!-- Bootstrap JS and dependencies (optional) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>

</body>
</html>