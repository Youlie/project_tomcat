<%@page import="com.aplose.smooss.bean.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP page</title>
</head>
<body>
<jsp:useBean id="userInfo" class="com.aplose.smooss.bean.UserInfo" scope="request"></jsp:useBean>
<jsp:setProperty property="name" name="userInfo" value="boubou"/>
<h1>Le nom d'utilisateur est : <%=((UserInfo)request.getAttribute("userInfo")).getName()%></h1>

</body>
</html>