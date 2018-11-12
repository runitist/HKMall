<%@page import="com.hkitedu.lee.DTO.DTO_car_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	DTO_car_info vo = (DTO_car_info) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자동차 쇼핑몰</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>자동차 쇼핑몰</h1>
		</header>
		<nav>
			<ul class="navul1">
				<li><a href="MainServlet">쇼핑몰 홈</a></li>
				<li><a href="MallServlet">자동차 몰</a></li>
				<li><a href="SellRankServlet">판매 순위</a></li>
			</ul>
		</nav>
		<section>
		<form action="UpdateCarServlet" method="post">
			<input name="c_namet" type="hidden" value="<%=vo.getC_name()%>" /><br />
			<label for="c_name">차량이름</label>
			<input id="c_name" name="c_name" type="text" value="<%=vo.getC_name()%>" /><br />
			<label for="c_type">차 종</label>
			<input id="c_type" name="c_type" type="text" value="<%=vo.getC_type()%>" /><br />
			<label for="c_regdate">출시일자</label>
			<input id="c_regdate" name="c_regdate" type="text" value="<%=vo.getC_regdate()%>" /><br />
			<label for="c_price">차량가격</label>
			<input id="c_price" name="c_price" type="text" value="<%=vo.getC_price()%>" /><br />
			<label for="c_cc">배기량</label>
			<input id="c_cc" name="c_cc" type="text" value="<%=vo.getC_cc()%>" /><br />
			<button type="submit">정보수정</button>
		</form>
		</section>
		<footer>
			<p>CopyRight 한국IT교육원 TM</p>
		</footer>
	</div>
</body>
</html>