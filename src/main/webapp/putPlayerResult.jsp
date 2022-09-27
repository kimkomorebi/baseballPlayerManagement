<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String result = request.getParameter("R");
		if(result.equals("Y")){
	%>
		<script type="text/javascript">
			alert("야구 선수에 등록에 성공하였습니다.");
		</script>
	<%
		}else if(result.equals("N")){
	%>
	<%	
		}
	%>
</body>
</html>