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

public class UpdateEmailServlet extends HttpServlet{
	
	UserDao ud = new UserDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		doPost(request,response); 
	    
 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String email = null;
		email = request.getParameter("email"); //��ȡ��Ҫ�޸ĵ�����
		String username =(String)request.getSession().getAttribute("user"); //��ȡ��ǰ��¼���û���
		try {
			ud.updateEmail(username, email);
			request.getRequestDispatcher("/user.jsp").forward(request, response);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.getSession().setAttribute("error","�޸�ʧ�ܣ�");
		request.getRequestDispatcher("/user.jsp").forward(request, response);	
		}
		
	}
}
