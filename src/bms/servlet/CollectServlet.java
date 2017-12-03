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
			if(action.equals("add")) //������ղ���Ʒ
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
			if(action.equals("show"))//�������ʾ���ﳵ
			{
				request.getRequestDispatcher("/user.jsp").forward(request, response);
			}
			if(action.equals("delete")) //�����ִ��ɾ�����ﳵ�е���Ʒ
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
	//�����Ʒ�����ﳵ�ķ���
		private boolean addToCollect(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception
		{
			String id = request.getParameter("id");//��ȡ�ղص�ͼ��id
			String name =(String)request.getSession().getAttribute("user"); //��ȡ��ǰ��¼���û���
			
			Book book = bd.findBookById(Integer.parseInt(id));
			
			//�Ƿ��ǵ�һ���ղ�,��Ҫ��session�д���һ���µ��ղض���
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
		//ɾ���ղ�
		private boolean deleteFromCollect(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception
		{
			String id = request.getParameter("id");
			String name =(String)request.getSession().getAttribute("user"); //��ȡ��ǰ��¼���û���
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
