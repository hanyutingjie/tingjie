<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
  margin: 0px 0px;
 }
   #top{
      background-color: #104E8B;
      width:100%;
      height:150px;
      font-size: 45px;
      font-family: 微软雅黑;
      color:white;
   }
   #main{
     /* background-color: green; */
      width:100%;
      height:480px;
   }
   #main_left{
      background-color: lightblue;
      width:17%;
      height:95%;
      float:left;
      padding-top:100px;
      padding-left:50px;
   }
   #main_left a{
     text-decoration: none;
     color: black;
     font-size: 20px;
   }
     #main_right{
      /* background-color: yellow;  */
      width:60%;
      height:80%;
      float:left;
   }
   #logo{
      margin-top:30px;
      margin-left:100px;
      margin-right:50px;
      float:left;
   }
   #logo_txt{
      margin-top:50px;
        float:left;
      /*   text-shadow: gray; */
   }
   #login_user{
      float:right;
      margin-right: 50px;
      font-size: 16px;
      font-family: 微软雅黑;
      color:white;
      margin-top:80px;
   }
   table{
   margin-top:30px;
   margin-left:50px;
   width:800px;
   text-align:certer;
   }
</style>
</head>
<body>

</head>
<body>
   <div id="top">
        <img id="logo" src="${pageContext.request.contextPath }/images/logo.png" width="150" height="100">
       <div id="logo_txt"> XXX车辆管理系统</div>               
       <div id="login_user">欢迎 ${loginUser.username }登录！</div>
   </div>
   <div id="main">
      <div id="main_left">
           <a href="UserServlet?flag=findAll">用户管理</a><br><br><br>
           <a href="CarServlet?flag=findAll">车辆管理</a>
      </div>
      <div id="main_right">
      <form action="UserServlet?flag=zengjia" method="post">
      增加用户<br><br>
      用户名:<input type="text" name="username" ><br><br>
      密码<input type="password" name="password"><br><br>
      <input type="submit" value="增加">
      </form>
      </div>
      </div>
</body>
</html>