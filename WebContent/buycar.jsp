<%@page import="com.hkitedu.lee.DTO.DTO_Join_carcom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	DTO_Join_carcom vo = (DTO_Join_carcom) request.getAttribute("vo");
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
			<table>
				<tr>
					<th>차량회사</th>
					<td><%=vo.getCom_name()%></td>
				</tr>
				<tr>
					<th>차량이름</th>
					<td><%=vo.getC_name()%></td>
				</tr>
				<tr>
					<th>차 종</th>
					<td><%=vo.getC_type()%></td>
				</tr>
				<tr>
					<th>출시일자</th>
					<td><%=vo.getC_regdate()%></td>
				</tr>
				<tr>
					<th>차량가격</th>
					<td><%=vo.getC_price()%></td>
				</tr>
				<tr>
					<th>배기량</th>
					<td><%=vo.getC_cc()%></td>
				</tr>
			</table>
			<form action="BuyCarServlet" method="post">
				<input type="hidden" name="c_price" value="<%=vo.getC_price()%>" />
				<input type="hidden" name="com_name" value="<%=vo.getCom_name()%>" />
				<button type="submit">차량구매</button>
			</form>
			<form action="UpdateCarServlet" method="get">
				<input type="hidden" name="c_name" value="<%=vo.getC_name()%>" />
				<input type="hidden" name="c_type" value="<%=vo.getC_type()%>" />
				<input type="hidden" name="c_regdate" value="<%=vo.getC_regdate()%>" />
				<input type="hidden" name="c_price" value="<%=vo.getC_price()%>" />
				<input type="hidden" name="c_cc" value="<%=vo.getC_cc()%>" />
				<button type="submit">정보수정</button>
			</form>

		</section>
		<footer>
			<p>CopyRight 한국IT교육원 TM</p>
		</footer>
	</div>
</body>
</html>