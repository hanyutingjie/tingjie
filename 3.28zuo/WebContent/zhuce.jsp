<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css" />
</head>
<body>
<img id="logo" src="${pageContext.request.contextPath }/images/li.jpg" >
 
 <div style="text-align:center;margin-top:-600px;margin-right:800px"> 
<form action="UserServlet?flag=zhuce" method="post">
用户注册<br><br>
用户名：<input type="text"name="username"/><br><br>
密码：    <input type="password"name="password"/><br><br>
<input type="submit"   value="注册" />
<input type="reset"   value="取消" />
</form>
</div>
</body>
</html>