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

public class DisplayServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 
	    BookService service = new BookServiceImpl();
	    int currentPage=1;
	    int count=30;
	    String value = request.getParameter("page");
	    if(value!=null&&!"".equals(value)){         
	        currentPage = Integer.parseInt(value);
	    }

        Pager page;
		try {
			page = service.findPage(currentPage, count);
			//System.out.println(page);
			request.setAttribute("page", page);
		    request.getRequestDispatcher("/index.jsp?page="+currentPage).forward(request, response); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request,response);
	}
}