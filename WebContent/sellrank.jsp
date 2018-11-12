<%@page import="java.util.List"%>
<%@page import="com.hkitedu.lee.DTO.DTO_RankCom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<DTO_RankCom> al = (List<DTO_RankCom>) request
			.getAttribute("al");
	List<DTO_RankCom> tl = (List<DTO_RankCom>) request
			.getAttribute("tl");
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
			<h3>회사별 차량 판매 대수</h3>
			<table>
				<tr>
					<th>회사 이름</th>
					<th>판매 대수</th>
				</tr>
				<%
					if (al != null) {
						for (int i = 0; i < al.size(); i++) {
				%>
				<tr>
					<td><%=al.get(i).getCom_name()%></td>
					<td><%=al.get(i).getCom_amount()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>
			<h3>회사별 차량 총판매 수익</h3>
			<table>
				<tr>
					<th>회사 이름</th>
					<th>총판매 수익</th>
				</tr>
				<%
					if (tl != null) {
						for (int i = 0; i < tl.size(); i++) {
				%>
				<tr>
					<td><%=tl.get(i).getCom_name()%></td>
					<td><%=tl.get(i).getCom_total()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>
		</section>
		<footer>
			<p>CopyRight 한국IT교육원 TM</p>
		</footer>
	</div>
</body>
</html>