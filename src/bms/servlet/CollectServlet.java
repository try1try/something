package bms.servlet;

import java.net.*;
import java.io.*;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bms.dao.*;
import bms.entity.*;
import bms.service.BookService;
import bms.service.BookServiceImpl;
import bms.util.StringUtil;

public class CollectServlet extends HttpServlet{
	private String action ; 
	BookDao bd = new BookDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		doPost(request,response); 
	    
 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("action")!=null)
		{
			this.action = request.getParameter("action");
			if(action.equals("add")) //如果是收藏商品
			{
				try {
					if(addToCollect(request,response))
					{
						request.getRequestDispatcher("/DisplayServlet").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("/DisplayServlet").forward(request, response);
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			if(action.equals("show"))//如果是显示购物车
			{
				request.getRequestDispatcher("/user.jsp").forward(request, response);
			}
			if(action.equals("delete")) //如果是执行删除购物车中的商品
			{
				try {
					if(deleteFromCollect(request,response))
					{
						request.getRequestDispatcher("/user.jsp").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("/user.jsp").forward(request, response);
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	//添加商品进购物车的方法
		private boolean addToCollect(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception
		{
			String id = request.getParameter("id");//获取收藏的图书id
			String name =(String)request.getSession().getAttribute("user"); //获取当前登录的用户名
			
			Book book = bd.findBookById(Integer.parseInt(id));
			
			//是否是第一次收藏,需要给session中创建一个新的收藏对象
			if(request.getSession().getAttribute(name)==null)
			{
				CollectList cl = new CollectList();
				request.getSession().setAttribute(name,cl);
			}
			CollectList cl = (CollectList)request.getSession().getAttribute(name);
			if(cl.addBooks(book))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		//删除收藏
		private boolean deleteFromCollect(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception
		{
			String id = request.getParameter("id");
			String name =(String)request.getSession().getAttribute("user"); //获取当前登录的用户名
			CollectList cl = (CollectList)request.getSession().getAttribute(name);
			Book book = bd.findBookById(Integer.parseInt(id));
			try {
			    if(cl.removeBooks(book))
			    {
			    	return true;
			    }
			    else
			    {
			    	return false;
			    }
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
		}
}
