<%@ page import="java.util.*" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>

<% 
//이게 왜 되는지 f12를 눌러봐도 모르겠다
	String name = "";
	name = (String)session.getAttribute("id");
	if(!(name!=null && name.equals("value"))){
%>
		<jsp:forward page="loginForm.jsp"/>
<%
	}
	else{
%>


<!DOCTYPE html>
<html>
<head>
    <title>board</title>
</head>

<body>

	당신은 성공했어요!<br>
	이미 로그인했다구요 어서오세요!\^0^/

</body>
</html>

<%}
%>