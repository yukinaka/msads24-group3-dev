<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>期間内受注集計画面</title>
		
		<!-- Temp.jspをinclude -->
		<%@ include file="Temp.jsp" %>
		
	</head>
	
	<body>
	
		<!-- Navbar.jspをinclude -->
		<%@ include file="Navbar.jsp" %>
		
		<div class="container text-center">
        <h2>期間内の受注集計</h2>

        <form action="/jsys/jsysFC" method="post" class="my-4">
            <div class="form-row justify-content-center">
                <div class="form-group col-md-4">
                    <label for="firstDay">From:</label>
                    <input type="date" class="form-control" id="firstDay" name="firstDay">
                </div>
                <div class="form-group col-md-4">
                    <label for="LastDay">To:</label>
                    <input type="date" class="form-control" id="LastDay" name="LastDay">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" name="buttonId" value="V301_01_01">集計</button>
        </form>

        <h4 class="text-danger">エラーメッセージエリア</h4>

        <table class="table table-bordered table-striped mt-4">
            <thead>
                <tr>
                    <th>得意先コード</th>
                    <th>得意先名</th>
                    <th>得意先別合計金額</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>KA0001</td>
                    <td>Aストア</td>
                    <td>500000</td>
                </tr>
                <tr>
                    <td>KA0015</td>
                    <td>Oストア</td>
                    <td>30000</td>
                </tr>
                <tr style="background-color: aqua;">
                    <td></td>
                    <td>総計</td>
                    <td>530000</td>
                </tr>
            </tbody>
        </table>
    </div>
    
    <!-- Footer.jspをinclude -->
		<%@ include file="Footer.jsp" %>
		
	</body>
</html>