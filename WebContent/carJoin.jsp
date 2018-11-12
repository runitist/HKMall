<%@page import="com.hkitedu.lee.DTO.DTO_company_info"%>
<%@page import="com.hkitedu.lee.DTO.DTO_car_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<DTO_company_info> ldci = (List<DTO_company_info>) request
			.getAttribute("ldci");
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
			<p>
				<b>원하는 차량회사가 없으면 <br />회사 등록 먼저 해주세요
				</b>
			</p>
			<button onclick="location.href='ComJoinServlet'">회사 등록</button>
			<form action="carJoinServlet" method="post">
				<label for="c_no">등록번호</label> <input id="c_no" name="c_no"
					type="text" value="<%=(int) request.getAttribute("maxc_no") + 1%>" /><br />
				<label for="com_name">차량회사</label> <select name="com_name" id="com_no">
					<%
						if (ldci != null) {
							for (int i = 0; i < ldci.size(); i++) {
					%>
					<option><%=ldci.get(i).getCom_name()%></option>
					<%
						}
						}
					%>
				</select><br /> <label for="c_name">차량이름</label> <input id="c_name"
					name="c_name" type="text" /><br /> <label for="c_type">차종</label>
				<select name="c_type" id="c_type">
					<option>승용차</option>
					<option>SUV</option>
				</select><br /> <label for="c_regdate">출시일자</label> <input id="c_regdate"
					name="c_regdate" type="date" /><br /> <label for="c_price">차량가격</label>
				<input id="c_price" name="c_price" type="text" /><br /> <label
					for="c_cc">배기량</label> <input id="c_cc" name="c_cc" type="text" /><br />
				<button type="submit">차량등록</button>
			</form>
		</section>
		<footer>
			<p>CopyRight 한국IT교육원 TM</p>
		</footer>
	</div>
</body>
</html>