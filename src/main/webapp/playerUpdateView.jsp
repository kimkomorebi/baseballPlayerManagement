<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="team.*, java.util.*" %>
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
			TeamList list = (TeamList)request.getAttribute("LIST");
			ArrayList<String> team = (ArrayList<String>)request.getAttribute("TEAM");
		%>
		<form action="playerUpdateNdelete.do" method="post">
			<table border="1">
				<tr>
					<th>번호</th>
					<td><input type="text" name="SEQNO" value="<%= list.getSeqno()%>" readOnly="readOnly"/></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="NAME" value="<%= list.getName()%>"/></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="ADDR" value="<%= list.getAddr()%>"/></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="BIRTH" value="<%= list.getBirth()%>"/></td>
				</tr>
				<tr>
					<th>소속팀</th>
					<td>
						<select name="TITLE">
							<%
								for(String t : team){
									if(t.equals(list.getTitle())){
							%>
								<option selected="selected"><%= t  %></option>
							<%
									}else {
							%>
								<option><%= t  %></option>
							<%
									}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>연봉</th>
					<td><input type="text" name="ANN_SAL" value="<%= list.getAnn_sal()%>"/></td>
				</tr>
				<tr>
					<th>등번호</th>
					<td><input type="text" name="B_NUM" value="<%= list.getB_num()%>"/></td>
				</tr>
			</table><br/>
			<input type="submit"  value="수정" name="BTN"/>
			<input type="submit"  value="삭제" name="BTN"/>
		</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>