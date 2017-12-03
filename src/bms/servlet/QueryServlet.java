package bms.servlet;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bms.dao.*;
import bms.entity.*;
import bms.service.BookService;
import bms.service.BookServiceImpl;
import bms.util.StringUtil;

public class QueryServlet extends HttpServlet{
	
	BookDao bd = new BookDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		doPost(request,response); 
	    
 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String key = null;
		key = request.getParameter("key");
		
		request.getSession().setAttribute("key",key);
			
		try {
			ArrayList<Book> books = (ArrayList<Book>) bd.query(key);
			request.getSession().setAttribute("books",books);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("error","未查询到结果！");
		request.getRequestDispatcher("/index.jsp").forward(request, response);	
		}
		
	}
}