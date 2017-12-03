package bms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bms.dao.UserDao;
import bms.entity.User;
import bms.service.*
;public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//验证登录
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		request.setAttribute("msg1", null); 
		//增加用户到数据库
		UserDao userDao = new UserDao();
		User user = new User();
		try {
			user = userDao.get(username);
			if(user!=null) {
				request.setAttribute("msg1", "该用户名已被注册！");  
	            request.getRequestDispatcher("/register.jsp").forward(request, response);  
	            return; 
			}
			if(user==null) {
				request.setAttribute("msg1", null); 
				User user1 = new User();
				user1.setUsername(username);
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				user1.setPassword(mdd5.md5(password));
				user1.setEmail(email);
				request.getRequestDispatcher("/DisplayServlet").forward(request, response);  
				try {
					userDao.addUser(user1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
	} 
	
}
