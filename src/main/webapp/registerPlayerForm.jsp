<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
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
			<h3>야구 선수 등록</h3>
			<form action="putPlayer.do" method="post">
				<table border="1">
					<tr>
						<th>이름</th>
						<td><input type="text" name="NAME"/></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="ADDR"/></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="text" name="BIRTH"/></td>
					</tr>
					<%
						ArrayList<String> team = (ArrayList<String>)request.getAttribute("TEAM");
					%>
					<tr>
						<th>소속팀</th>
						<td>
							<select name="TITLE">
								<%
									for(String t : team){
								%>
									<option><%= t %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>등번호</th>
						<td><input type="text" name="B_NUM"/></td>
					</tr>
					<tr>
						<th>연봉</th>
						<td><input type="text" name="ANN_SAL"/></td>
					</tr>
				</table><br/>
				<input type="submit" value="등 록"/>
				<input type="reset" value="취 소"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>