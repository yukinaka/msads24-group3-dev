<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>得意先一覧</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <!-- Temp.jspをinclude -->
    <%@ include file="Temp.jsp" %>
</head>
<body>

    <!-- Navbar.jspをinclude -->
    <%@ include file="V400_03Navbar.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">得意先一覧</h2>
        
        <div class="text-center text-danger mt-4">
            エラーメッセージエリア<br>
        </div>
       <br>
        
        <div class="d-flex justify-content-center mb-4">
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="検索" aria-label="Search">
                <button class="btn btn-primary" type="submit">検索</button>
                <div class="form-check ms-3">
                    <input class="form-check-input" type="checkbox" id="ckbutton">
                    <label class="form-check-label" for="ckbutton">
                       削除済み項目も含める
                    </label>
                </div>
            </form>
        </div>
        
        <p class="text-center text-muted">
            ※削除済み項目も検索したい場合は「削除済み項目も含める」にチェックを入れてください。
        </p>


        <div class="table-responsive">
            <table class="table table-bordered text-center">
                <thead>
                    <tr>
                        <th>得意先コード</th>
                        <th>
                        	<div class="btn-group" role="group">
							    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle"
							        data-bs-toggle="dropdown" aria-expanded="false">得意先名</button>
							    <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
							      <li><a class="dropdown-item" href="#nest_button_group">昇順</a></li>
							      <li><a class="dropdown-item" href="#nest_button_group">降順</a></li>
							    </ul>
							  </div>
                        </th>
                        <th>電話番号</th>
                        <th>郵便番号</th>
                        <th>住所</th>
                        <th>割引率</th>
                        <th>最終更新者</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a href="#">KA0001</a></td>
                        <td>Aストア</td>
                        <td>045-128-3581</td>
                        <td>220-0001</td>
                        <td>横浜市西区北幸2-1</td>
                        <td style="text-align:right">0%</td>
                        <td>HA0001</td>
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td><a href="#">KA0002</a></td>
                        <td>Bストア</td>
                        <td>045-128-3581</td>
                        <td>220-0001</td>
                        <td>横浜市西区北幸2-1</td>
                        <td style="text-align:right">0%</td>
                        <td>HA0001</td>
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td><a href="#">KA0005</a></td>
                        <td>Eストア</td>
                        <td>045-128-3581</td>
                        <td>220-0001</td>
                        <td>横浜市西区北幸2-1</td>
                        <td style="text-align:right">0%</td>
                        <td>HA0001</td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="container-fluid">
		  <div class="row justify-content-between">
		  	<div class="col order-3 my-box" style="text-align: right;"><a href="#">次ページ</a></div>
		    <div class="col order-2 my-box" style="text-align: center;">2/3ページ</div>
		    <div class="col order-1 my-box" style="text-align: left: ;"><a href="#">前ページ</a></div>
		  </div>
		</div>


    </div>

    <!-- Footer.jspをinclude -->
    <%@ include file="Footer.jsp" %>

    <!-- Bootstrap JS CDN -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>