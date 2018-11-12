<%@page import="com.hkitedu.lee.DTO.DTO_car_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<DTO_car_info> carList = (List<DTO_car_info>) request
			.getAttribute("carList");
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
			<table class="carlisttable">
				<tr>
					<th>등록번호</th>
					<th>차량이름</th>
					<th>출시일자</th>
					<th>차량가격</th>
				</tr>
				<%
					if (carList != null) {
						for (int i = 0; i < carList.size(); i++) {
				%>
				<tr>
					<td><%=carList.get(i).getC_no()%></td>
					<td><a href="BuyCarServlet?C_no=<%=carList.get(i).getC_no()%>"><%=carList.get(i).getC_name()%></a></td>
					<td><%=carList.get(i).getC_regdate()%></td>
					<td><%=carList.get(i).getC_price()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>
			<button class="carjoinbutton" onclick="location.href='carJoinServlet'">차량 등록</button>
		</section>
		<footer>
			<p>CopyRight 한국IT교육원 TM</p>
		</footer>
	</div>
</body>
</html>