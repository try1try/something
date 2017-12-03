<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>register</title>
	<link rel="stylesheet" type="text/css" href="css/register.css">
	
</head>
<body>
	<%
		String errorInfo =(String)request.getAttribute("msg1");        // 获取错误属性
		if(errorInfo != null) {
	%>
		<script type="text/javascript" language="javascript">
		alert("<%=errorInfo%>");                                        
		</script>
	<%
		}
	%>
	<div class = "wrapper">
	 	<form name = "Comment form" method="post" action="/BookManageSystem/RegisterServlet">
	 		<div class = "caption">Sign Up</div>
			<table>
	        	<!--用户名-->
				<tr >
					<td class = "first_row">Username:</td>
					<td><input type="text" class="text" id = "name" name="username" size="40" maxlength="20" placeholder="What is your usename?" onfocus="usenameFocus()" onblur="usenameBlur()"></td>
					<td class = "prompt"><div><p id="nameMsg">
					&nbsp;&nbsp;6-10位数字字母汉字或下划线组成
					</p></div></td>
	
				</tr>
	            <!--密码-->
				<tr>
					<td class = "first_row">Password:</td>
					<td><input type="password" class="text" id = "pwd1" name="password" size="30" maxlength="25" placeholder="Please enter your password." onfocus="pwd1Focus()" onblur="pwd1Blur()"></td>
					<td class = "prompt"><div><p id="pwd1Msg">&nbsp;&nbsp;6-16字母数字或符号组合而成。</p></div></td>
				</tr>
	            <!--确认密码-->
				<tr>
					<td class = "first_row">Confirm:</td>
					<td><input type="password" class="text" id = "pwd2"name="confirm_password" size="40" maxlength="16" placeholder="Please confirm your password." onfocus="pwd2Focus()" onblur="pwd2Blur()"></td>
					<td class = "prompt"><div><p id="pwd2Msg">&nbsp;&nbsp;请再次输入密码</p></div></td>
				</tr>
	            <!--email-->
				<tr>
					<td class = "first_row">Email:</td>
					<td><input type="text" class="text" name="email" id = "tel"
					size="40" maxlength="50" placeholder="Please enter your email." onfocus="telFocus()" onblur="telBlur()"></td>
					<td class = "prompt"><div><p id="telMsg">&nbsp;&nbsp;请输入正确的邮箱地址，方便联系您。</p></div></td>
				</tr>
	             <!--重置提交按钮-->
				<tr>
					<td class = "button" colspan="3">
						<button class = "reset" type="reset" >Reset</button>
						<button class = "submit" type="submit">Register</button>
					</td>
				</tr>
	          
			
			</table>
			
	 </form>
 </div>
 	<script src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
 	<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src = "js/register.js"> </script>
	
	<div class = "bms">
		<h1>BookManageSystem</h1>
	</div>
</body>
</html>