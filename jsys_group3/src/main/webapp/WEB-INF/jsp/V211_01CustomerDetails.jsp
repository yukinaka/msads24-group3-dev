<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得意先詳細情報</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>
</head>
<body>
    <!-- Navbar.jspをinclude -->
    <%@ include file="V400_03Navbar.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center mb-4">得意先詳細情報</h2>
        
        <div class="row justify-content-center">
            <div class="col-md-8">
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th scope="row">得意先コード</th>
                            <td>KA0001</td>
                        </tr>
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
                        </tr>
                        <tr>
                            <th scope="row">住所2</th>
                            <td>横浜市西区北幸2-2</td>
                        </tr>
                        <tr>
                            <th scope="row">割引率</th>
                            <td class="text-right">0%</td>
                        </tr>
                        <tr>
                            <th scope="row">最終更新者</th>
                            <td>HA0001</td>
                        </tr>
                    </tbody>
                </table>

                <div class="text-center mt-4">
                    <form action="/jsys/jsysFC" method="post">
                        <button type="submit" class="btn btn-secondary mr-2" name="buttonId" value="99">前画面へ戻る</button>
                        <button type="submit" class="btn btn-primary mr-2" name="buttonId" value="99">変更</button>
                        <button type="submit" class="btn btn-danger" name="buttonId" value="99">復元</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>