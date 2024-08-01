<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>得意先変更</title>

<!-- Bootstrap CSS CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

<!-- Temp.jspをinclude -->
<%@ include file="Temp.jsp" %>

</head>
<body>

<!-- Navbar.jspをinclude -->
<%@ include file="V400_03Navbar.jsp" %>

<div class="container mt-5">
  <h2 class="text-center">得意先変更</h2>
  
<br>  
<div style="text-align:center" >
<font color="red">
<h4>エラーメッセージエリア</h4>
</font>
</div>
<br> 
  <form action="" method="post">
    <div class="row justify-content-center">
      <div class="col-md-8 col-lg-6">
        <div class="card p-4">
          <div class="card-body">
            <div class="mb-3">
              <label for="customerCode" class="form-label">得意先コード</label>
              <input type="text" class="form-control" id="customerCode" name="customerCode" required>
            </div>
            <div class="mb-3">
              <label for="customerName" class="form-label">得意先名</label>
              <input type="text" class="form-control" id="customerName" name="customerName" maxlength="32" title="得意先名は32文字以内で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="phoneNumber" class="form-label">電話番号1</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。" required>
            </div>
             <div class="mb-3">
              <label for="phoneNumber" class="form-label">電話番号2</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。" required>
            </div>
             <div class="mb-3">
              <label for="phoneNumber" class="form-label">電話番号3</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="postalCode" class="form-label">郵便番号1</label>
              <input type="text" class="form-control" id="postalCode" name="postalCode" pattern="^[0-9]{7}$" title="郵便番号は7桁で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="address" class="form-label">住所1</label>
              <input type="text" class="form-control" id="address" name="address" maxlength="40" title="住所は40文字以内で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="postalCode" class="form-label">郵便番号2</label>
              <input type="text" class="form-control" id="postalCode" name="postalCode" pattern="^[0-9]{7}$" title="郵便番号は7桁で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="address" class="form-label">住所2</label>
              <input type="text" class="form-control" id="address" name="address" maxlength="40" title="住所は40文字以内で入力してください。" required>
            </div>
            <div class="mb-3">
              <label for="discountRate" class="form-label">割引率</label>
              <input type="text" class="form-control" id="discountRate" name="discountRate" pattern="^[0-9]{1,2}$" title="割引率は0~99までの整数値で入力してください。" required>
            </div>
            
            <div class="text-center">
              <button type="submit" class="btn btn-primary">変更</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</div>

<!-- Footer.jspをinclude -->
<%@ include file="Footer.jsp" %>

<!-- Bootstrap JS and dependencies (optional) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>

</body>
</html>