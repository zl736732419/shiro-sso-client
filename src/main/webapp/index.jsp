<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/cas-login">点击登录</a>
		<br />
	</shiro:guest>
	<shiro:user>
    欢迎[<shiro:principal />]登录<br />
	</shiro:user>
	<shiro:hasRole name="admin">
    您有角色admin
</shiro:hasRole>
<br/>
<a href="https://localhost:8443/sso-server/logout?service=http://localhost:8080/sso-client">退出系统</a>

</body>
</html>