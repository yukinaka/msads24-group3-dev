<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>得意先変更</title>

<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>

</head>
<body>

<!-- LoginNavbar.jspをinclude -->
		<%@ include file="LoginNavbar.jsp" %>

<div style="text-align:center">
<h2>得意先変更</h2>
</div>

<button type="submit" >メニュー画面へ戻る</button>
<button type="submit" >ログアウト</button>

<div style="text-align:center">
  <form action="" method="post">
  <table style="margin:0 auto">
  
  	<tr>
    <td align="right">得意先コード</td>
  	 <td></td>
    </tr>
    <tr>
    <td align="right">得意先名</td>
   <td> <input type="text" name="customerName" maxlength="32" "title="得意先名は32文字以内で入力してください。"
    required></td>
    </tr>
    <tr>
    <td align="right">電話番号</td>
    <td><input type="text" name="deptId" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。"
      required></td>
    </tr>
    <tr>
    <td align="right">郵便番号</td>
    <td><input type="text" name="phone" pattern="^[0-9]{7}$" "title="郵便番号は7桁で入力してください。"
      required></td>
     </tr>
     <tr>
    <td align="right">住所</td>
    <td><input type="text" name="phone" maxlength="40" "title="住所は40文字以内で入力してください。"
      required></td>
     </tr>
     <tr>
    <td align="right">割引率</td>
    <td><input type="text" name="phone" pattern="^[0-9]{2}$" "title="割引率は0~99までの整数値で入力してください。"
      required></td>
     </tr>
     
     
    </table> 
    <br>
    <div style="text-align:center">
    <input type="submit" value="変更">
    </div>
    <br>
     <tr>
    <td align="right">メッセージエリア</td>
  	 <td><input type="text" ></td>
    </tr>
  </form>
 </div>
  <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>

</body>
</html>