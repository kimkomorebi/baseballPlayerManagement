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
			<h3>�߱� ���� ���</h3>
			<form action="putPlayer.do" method="post">
				<table border="1">
					<tr>
						<th>�̸�</th>
						<td><input type="text" name="NAME"/></td>
					</tr>
					<tr>
						<th>�ּ�</th>
						<td><input type="text" name="ADDR"/></td>
					</tr>
					<tr>
						<th>�������</th>
						<td><input type="text" name="BIRTH"/></td>
					</tr>
					<%
						ArrayList<String> team = (ArrayList<String>)request.getAttribute("TEAM");
					%>
					<tr>
						<th>�Ҽ���</th>
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
						<th>���ȣ</th>
						<td><input type="text" name="B_NUM"/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" name="ANN_SAL"/></td>
					</tr>
				</table><br/>
				<input type="submit" value="�� ��"/>
				<input type="reset" value="�� ��"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>