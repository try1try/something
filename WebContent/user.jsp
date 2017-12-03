<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,java.sql.*,bms.dao.BookDao,bms.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    

<link rel="stylesheet" type="text/css" href="css/book.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>个人主页</title>
</head>
<body>
	<div id = "wrap">
    	<div id = "header">
        	<ul id = "header_navbar" class = "navbar-fixed-top">
               <li><img src="images/sun.png"></li>
               <li class = "info"><a class = "a1" href="#" target= "_blank" >你好,${user}</a></li>
               <li class="travel_index" ><a class = "a1" href="/BookManageSystem/DisplayServlet">首页</a></li>
                <li class="source"><a class = "a1" href="/BookManageSystem/CollectServlet?action=show" target= "_blank" style="color:rgba(255,81,81,1);">个人主页</a></li>
                <li class="book"><a class = "a1" href="/BookManageSystem/login.jsp" target= "_blank" >会员登录</a></li>
                <li class="anthor"><a class = "a1" href="/BookManageSystem/register.jsp" target= "_blank">加入我们</a></li>
                <li></li>
             </ul>
             
            <div class = "header-banner">
            	<img class="img-responsive" src="images/book-banner.jpg">
            </div>
        </div>
        
        <div id = "mainbody">
        	<div id = "main_left">
            	<a name = "1"></a>
            	<span class = "caption1">个人收藏</span>
   
				 <table class="table table-width table-hover">
				  <thead>
				    <tr>
				      <th>书名</th>
				      <th>作者</th>
				      <th>出版社</th>
				      <th>发行日期</th>
				      <th>评分</th>
				      <th>参评人数</th>
				      <th>价格</th>
				      <th>标签</th>
				    </tr>
				  </thead>
				  <tbody>
	        	    <%
	        	    String name =(String)request.getSession().getAttribute("user"); //获取当前登录的用户名 
					   //首先判断session中是否有购物车对象
					   if(request.getSession().getAttribute(name)!=null)
					   {
					%>
						<% 
						CollectList cl = (CollectList)request.getSession().getAttribute(name);
						LinkedList<Book> books = cl.getBooks();
						for(Book book:books) {
				        %> 
			          <tr>
			              <td><%=book.getTitle() %></td>
			              <td><%=book.getAuthor() %></td>
			              <td><%=book.getPublish() %></td>
			              <td><%=book.getDate() %></td>
			              <td><%=book.getScore() %></td>
			              <td><%=book.getPerson() %></td>
			              <td><%=book.getPrice() %></td>
			              <td><%=book.getTag() %></td>
			              <td> <a href="/BookManageSystem/CollectServlet?action=delete&id=<%=book.getId()%>" onclick="delcfm();"><img src="images/delete.png"></a></td>
			          </tr>
   					<%	}%>
   					<%} %>
				
				  </tbody>
				  
				</table>
				
            </div>
            <div id = "main_right">
            <span>修改邮箱</span>
            <hr>
            	<form action="/BookManageSystem/UpdateEmailServlet" id="bookForm"  method="post">
				<input type="text" name = "email" class="form-control"placeholder="请输入修改的邮箱名"/>  
            	<span class="input-group-btn">  
                <button class="btn btn-info btn-search button" onclick="updateName()">修改</button>  
            </span>  
            </div>
        </div>
	    <div id = "footer">
	    		
	        <div class="last">Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;20170515&nbsp;&nbsp;by&nbsp;计科1502&nbsp;薛冰</div>
	    </div>
    </div>
    <script language="javascript">
	    function delcfm() {
	        if (!confirm("确认要删除？")) {
	            window.event.returnValue = false;
	        }
	    }
	    function updateName() {
	    	alert("修改成功!");
	    }
   </script>
</body>
</html>