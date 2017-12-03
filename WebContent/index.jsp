<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" import="java.sql.*,bms.dao.BookDao,bms.entity.*,java.util.List"%>
<%
String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    

<link rel="stylesheet" type="text/css" href="css/book.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

    
<title>index</title> 
</head>
<body>
	<div id = "wrap">
    	<div id = "header">
        	<ul id = "header_navbar" class = "navbar-fixed-top">
               <li><img src="images/sun.png"></li>
               <li class = "info"><a class = "a1" href="#" target= "_blank" >你好,${user}</a></li>
               <li class="travel_index" ><a class = "a1" href="#" style="color:rgba(255,81,81,1);">首页</a></li>
                <li class="source"><a class = "a1" href="/BookManageSystem/CollectServlet?action=show" target= "_blank" >个人主页</a></li>
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
            	<span class = "caption1">好书推荐</span>
   
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
				  
				  <c:if test="${not empty key }">
				    <c:if test="${empty books }">
				    	<span>${error }</span>
				    </c:if>
            		<c:forEach items="${books }" var="book">
			          <tr>
			              <td>${book.getTitle() }</td>
			              <td>${book.getAuthor() }</td>
			              <td>${book.getPublish() }</td>
			              <td>${book.getDate() }</td>
			              <td>${book.getScore() }</td>
			              <td>${book.getPerson() }</td>
			              <td>${book.getPrice() }</td>
			              <td>${book.getTag() }</td>
			              <td><a href="/BookManageSystem/CollectServlet?action=add&id=${book.getId()}" onclick="collect();"><img src="images/collect.png"></a></td>
			          </tr>
       			  </c:forEach>
       			  
        		 </c:if>
        		 <c:forEach items="${page.books }" var="book">
			          <tr>
			              <td>${book.getTitle() }</td>
			              <td>${book.getAuthor() }</td>
			              <td>${book.getPublish() }</td>
			              <td>${book.getDate() }</td>
			              <td>${book.getScore() }</td>
			              <td>${book.getPerson() }</td>
			              <td>${book.getPrice() }</td>
			              <td>${book.getTag() }</td>
			              <td><a href="/BookManageSystem/CollectServlet?action=add&id=${book.getId()}" onclick="collect();"><img src="images/collect.png"></a></td>
			          </tr>
       			  </c:forEach>
				  </tbody>
				  
				</table>
				<br>
				<div align="center">
			    <c:if test="${page.currentPage>1 }">
			        <a href="${pageContext.request.contextPath }/DisplayServlet?page=${page.currentPage-1}">上一页</a>
			    </c:if>
			        <a href="${pageContext.request.contextPath }/DisplayServlet?page=${1}">首页</a>
			            <c:forEach begin="1" end="${page.totalPage }" step="1" var="i">
			                <c:if test="${page.currentPage==i }">
			                    <a href="${pageContext.request.contextPath }/DisplayServlet?page=${i}"><font color="#ff0000">${i}</font></a>
			                </c:if>
			                <c:if test="${page.currentPage!=i }">
			                    <a href="${pageContext.request.contextPath }/DisplayServlet?page=${i}">${i}</a>
			                </c:if>
			            </c:forEach>
			        <a href="${pageContext.request.contextPath }/DisplayServlet?page=${page.totalPage}">末页</a>
			    <c:if test="${page.currentPage< page.totalPage }">
			        <a href="${pageContext.request.contextPath }/DisplayServlet?page=${page.currentPage+1}">下一页</a>
			    </c:if>
			    </div>
            </div>
            <div id = "main_right">
            <span>帮助</span>
            <hr>
            <form action="/BookManageSystem/QueryServlet" id="bookForm"  method="post">
				<input type="text" name = "key" class="form-control"placeholder="请输入字段名"/>  
            	<span class="input-group-btn">  
                <button class="btn btn-info btn-search button">查找</button>  
            </span>  
			</form>
            </div>
        </div>
    <div id = "footer">
    		
        <div class="last">Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;20170515&nbsp;&nbsp;by&nbsp;计科1502&nbsp;薛冰</div>
    </div>
  </div>
</body>
	<script type="text/javascript" src="js/book.js"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="http://img.jb51.net/jslib/jquery/jquery14.js" type="text/javascript"></script> 
    <script src="js/bootstrap-table.js"></script>  
    <script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
    <script language="javascript">
		function collect()
		{ 
		   alert("收藏成功!");
		   
		}
	</script>
</html>