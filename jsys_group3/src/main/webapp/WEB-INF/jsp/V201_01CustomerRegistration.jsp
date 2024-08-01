<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得意先登録</title>

    <%-- 埋め込みスタイルシート（入力規則違反はピンクで表示） --%>
    <style type="text/css">
        input:invalid {
            background-color: pink;
        }
    </style>

    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>
    <!-- Bootstrap CSSを追加 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <!-- Navbar.jspをinclude -->
    <%@ include file="V400_03Navbar.jsp" %>

    <%-- 見出し --%>
    <div class="container mt-5">
        <h2 class="text-center">得意先登録入力</h2>

        <%-- エラーメッセージ領域 --%>
        <%--
        <div class="text-center text-danger font-weight-bold">
            <c:out value="${ requestScope.errorMessage }" />
        </div>
        --%>

        <%-- フォーム領域 --%>
        <div class="text-center mt-3">
            <form action="/jsys/V201_02CustomerRegistrationConfirmation" method="post">
            	<font color="red">エラーメッセージ</font>
            	<br>
                <div class="form-group row">
                    <label for="custName" class="col-sm-4 col-form-label text-right">得意先名：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="custName" name="custName" maxlength="32" title="得意先名は32文字以内で入力してください。">
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="telNo" class="col-sm-4 col-form-label text-right">電話番号1：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="telNo1" name="telNo1" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="telNo" class="col-sm-4 col-form-label text-right">電話番号2：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="telNo2" name="telNo2" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="telNo" class="col-sm-4 col-form-label text-right">電話番号3：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="telNo3" name="telNo3" pattern="^[0-9]{13}$" title="電話番号は数字13桁で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="postalCode" class="col-sm-4 col-form-label text-right">郵便番号1：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="postalCode1" name="postalCode1" pattern="^[0-9]{7}$" title="郵便番号は7桁で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-4 col-form-label text-right">住所1：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="address1" name="address1" maxlength="40" title="住所は40文字以内で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="postalCode" class="col-sm-4 col-form-label text-right">郵便番号2：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="postalCode2" name="postalCode2" pattern="^[0-9]{7}$" title="郵便番号は7桁で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-4 col-form-label text-right">住所2：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="address2" name="address2" maxlength="40" title="住所は40文字以内で入力してください。">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="discountRate" class="col-sm-4 col-form-label text-right">割引率：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="discountRate" name="discountRate" pattern="^[1-9]?[0-9]$" title="割引率は0~99までの整数値で入力してください。">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary mt-3">登録</button>
            </form>
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
