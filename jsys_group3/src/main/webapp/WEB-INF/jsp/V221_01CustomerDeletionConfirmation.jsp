<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得意先削除確認</title>
    <!-- Bootstrap CSSを追加 -->
    <%@ include file="Temp.jsp" %>
</head>
<body>

<!-- Navbar.jspをinclude -->
<%@ include file="V400_04Navbar.jsp" %>

<div class="container text-center mt-5">
    <h2>得意先削除確認</h2>
    <p>以下の得意先を削除します。よろしいですか？</p>

    <table class="table table-bordered w-50 mx-auto">
        <tbody>
            <tr>
                <th scope="row">得意先名</th>
                <td>Aストア</td>
            </tr>
            <tr>
                <th scope="row">電話番号1</th>
                <td>045-128-3581</td>
            </tr>
            <tr>
                <th scope="row">電話番号2</th>
                <td>045-128-3582</td>
            </tr>
            <tr>
                <th scope="row">電話番号3</th>
                <td>045-128-3583</td>
            </tr>
            <tr>
                <th scope="row">郵便番号1</th>
                <td>220-0001</td>
            </tr>
            <tr>
                <th scope="row">住所1</th>
                <td>横浜市西区北幸2-1</td>
            </tr>
            <tr>
                <th scope="row">郵便番号2</th>
                <td>220-0002</td>
            <tr>
                <th scope="row">住所2</th>
                <td>横浜市西区北幸2-2</td>
            </tr>
            <tr>
                <th scope="row">割引率</th>
                <td>0%</td>
            </tr>
        </tbody>
    </table>

    <div class="mt-4">
        <button type="button" class="btn btn-danger mr-2" name="buttonId" value="delete">はい</button>
        <button type="button" class="btn btn-secondary" name="buttonId" value="cancel">キャンセル</button>
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
