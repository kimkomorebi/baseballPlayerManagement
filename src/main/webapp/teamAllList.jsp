<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, team.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div align="center">
			<h2>팀 정보</h2>

				<table border="1">
					<tr>
						<th>팀번호</th>
						<th>팀 이름</th>
						<th>연고지역</th>
						<th>구단주</th>
						<th>창단일</th>
					</tr>
					<%
						ArrayList<TeamList> list = (ArrayList<TeamList>)request.getAttribute("LIST");
					%>
					<%
						for(TeamList l : list){
					%>
						<tr>
							<td><%= l.getT_id() %></td>
							<td><%= l.getTitle() %></td>
							<td><%= l.getTown() %></td>
							<td><%= l.getO_name() %></td>
							<td><%= l.getFounding() %></td>
						</tr>
					<%
						}
					%>
				</table>
				<br/>
			<form action="putPlayerNlist.do" method="get">
				<input type="button" value="선수 등록" name="BTN" onClick=""/>
				<input type="submit" value="선수 목록" name="BTN"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>