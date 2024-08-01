<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先登録確認画面</title>
<!-- Temp.jspをinclude -->
<%@ include file="Temp.jsp" %>
<!-- Bootstrap CSSを追加 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Navbar.jspをinclude -->
<%@ include file="V400_04Navbar.jsp" %>

<div class="container mt-5">
 <div class="text-center">
   <h2>登録確認</h2>
   <p>以下の得意先を登録します。よろしいですか？</p>
   <div class="row justify-content-center">
     <div class="col-md-6">
       <table class="table table-bordered">
         <tr>
           <th>登録先名</th>
           <td><c:out value="${ requestScope.customer.custName }" default = "Aストア"/></td>
         </tr>
         <tr>
           <th>電話番号1</th>
           <td><c:out value="${ requestScope.customer.telNo1 }" default = "045-128-3581"/></td>
         </tr>
         <tr>
           <th>電話番号2</th>
           <td><c:out value="${ requestScope.customer.telNo2 }" default = "045-128-3582"/></td>
         </tr>
         <tr>
           <th>電話番号3</th>
           <td><c:out value="${ requestScope.customer.telNo3 }" default = "045-128-3583"/></td>
         </tr>
         <tr>
           <th>郵便番号1</th>
           <td><c:out value="${ requestScope.customer.postalCode1 }" default = "220-0001"/></td>
         </tr>
         <tr>
           <th>住所1</th>
           <td><c:out value="${ requestScope.customer.address1 }" default = "横浜市西区北幸２－１"/></td>
         </tr>
         <tr>
           <th>郵便番号2</th>
           <td><c:out value="${ requestScope.customer.postalCode2 }" default = "220-0002"/></td>
         </tr>
         <tr>
           <th>住所2</th>
           <td><c:out value="${ requestScope.customer.address2 }" default = "横浜市西区北幸２－５"/></td>
         </tr>
         <tr>
           <th>割引率</th>
           <td><c:out value="${ requestScope.customer.discountRate }" default = "0"/></td>
         </tr>
       </table>
       <div class="mt-3">
         <button class="btn btn-primary">はい</button>
         <button class="btn btn-secondary">キャンセル</button>
       </div>
     </div>
   </div>
 </div>
</div>
<!-- Footer.jspをinclude -->
<%@ include file="Footer.jsp" %>

<!-- Bootstrap JSと依存するPopper.jsとjQueryを追加 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
