<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
		<div class="wrapper">
			<div class="container">
				
				<% 
					request.setCharacterEncoding("utf-8");
					String username="";
					Cookie[] cookies = request.getCookies();
					if(cookies!=null && cookies.length>0) {
						for(Cookie c:cookies) {
							if(c.getName().equals("username")) {
								username = URLDecoder.decode(c.getValue(),"utf-8");
							}
						}
					}  
				%>		
				<form class="form" action="/BookManageSystem/LoginServlet" method="post">
					<input name="username" type="text" value="<%=username %>" placeholder="Username">
					<input name="password" type="password" placeholder="Password">
					<input class = "valid" name="validationCode" type="text">
					<div  class = "validationCode_img"><img class = "v_img" src="/BookManageSystem/CheckServlet"></div>
					<div class = "remember">
						<input class = "check" name="isRemember" type="checkbox" checked="checked">
						<label class = "label">Remember</label>
					</div>
					<button type="submit" id="login-button">Login</button>
					<font color="red" size="2"> ${msg }</font>  
					<a href = "register.jsp">立即注册</a>
				</form>
			</div>
		</div>
	<script src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
	<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="js/login.js" type="text/javascript"></script>

	<div style="text-align:center;margin:70px 0; font:normal 20px/24px 'Calibri';color:#000000">
		<h1>BookManageSystem</h1>
	</div>
</body>
</html>