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
		<%
			ArrayList<TeamList> list = (ArrayList<TeamList>)request.getAttribute("LIST");
		%>
		<table border="1">
			<tr>
				<th>��ȣ</th>
				<th>�̸�</th>
				<th>�ּ�</th>
				<th>�������</th>
				<th>�Ҽ���</th>
				<th>����</th>
				<th>���ȣ</th>
			</tr>
			<%
				for(TeamList l : list){
			%>
				<tr>
					<td><a href="playerUpdate.do?SEQNO=<%= l.getSeqno() %>"><%= l.getSeqno() %></a></td>
					<td><%= l.getName() %></td>
					<td><%= l.getAddr() %></td>
					<td><%= l.getBirth() %></td>
					<td><%= l.getTitle() %></td>
					<td><%= l.getAnn_sal() %></td>
					<td><%= l.getB_num() %></td>
				</tr>
			<%
				}
			%>
		</table>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>