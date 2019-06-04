<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
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
   #f1{
   float:right;
   margin-right:300px;
   margin-top:30px;

   }
   #f1{
   float:right;
   margin-right:300px;
   margin-top:30px;

   }
   #icon{
      margin-left:300px;
   }
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
 <script type="text/javascript">
    $(function(){
       $("#icon").click(function(){
    	   if($("#f1").css("display")=="none")
    	       $("#f1").slideDown(500);
    	   else
    		   $("#f1").slideUp(500); 
       });
    });
 </script>
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
      <a href="car_add.jsp">增加</a>
      <img id="icon" src="${pageContext.request.contextPath }/images/down.jpg" width="10" height="10">
      <form action="CarServlet?flag=findByName" method="post" id="f1">
             请输入您要查询的车名：<input type="text" name="name"/><br><br>
            请输入您要查询的颜色：<input type="text" name="color"/><br><br>
            请输入您要查询的价格区间：<input type="text" name="price1" size="5" value="0.0"/>万元-
                   <input type="text" name="price2" size="5" value="0.0"/>万元<br><br>
 
      <input type="submit" value="查询">
      </form>
      <div id="main_right">
      <table border="1" cellspacing="0" cellpadding="0">
         <tr style="background-color:gray;color:white;">
                 <tr>
                    <td>编号</td>
                    <td>颜色</td>
                    <td>名称</td>
                    <td>图片</td>
                    <td>价格</td>
                    <td>操作</td>
                 </tr>
                <c:forEach items="${cars }" var="c">
                    <tr>
                    <td>${c.id}</td>
                     <td>${c.color }</td>
                     <td>${c.name}</td> 
                     <td><img src="/car/${c.img }" width="40" height="30"/></td>
                     <td>${c.price }</td>
                     <td>
                     <a href="CarServlet?flag=yupdate&id=${c.id }">修改</a>
                     <a href="CarServlet?flag=delete&id=${c.id }">删除</a>                    
                     </td>
                  </tr>
                 </c:forEach>  
      </table>       
      </div>
   </div>
</body>
</html>