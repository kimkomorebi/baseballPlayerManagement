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
			<h2>�� ����</h2>

				<table border="1">
					<tr>
						<th>����ȣ</th>
						<th>�� �̸�</th>
						<th>��������</th>
						<th>������</th>
						<th>â����</th>
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
				<input type="button" value="���� ���" name="BTN" onClick=""/>
				<input type="submit" value="���� ���" name="BTN"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>