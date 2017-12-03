package bms.servlet;

import java.net.*;
import java.io.*;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bms.dao.UserDao;
import bms.entity.*;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//验证登录
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("validationCode");
		String saveCode = (String)request.getSession().getAttribute("check_code");
		PrintWriter out = response.getWriter();
		//检查验证码是否正确
		if(!saveCode.equalsIgnoreCase(checkCode)) {
			request.setAttribute("msg", "验证码错误！");  
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
            return;  
		}
		//检查用户是否存在
		UserDao userDao = new UserDao();
		User user = new User();
		try {
			user = userDao.get(username);
			if(password.equals(user.getPassword())) {
				//out.println("您好,"+ user.getUsername());
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				session.setAttribute("email", user.getEmail());
				response.sendRedirect(request.getContextPath()+"/DisplayServlet");
			}else {
				request.setAttribute("msg", "密码不正确！");  
	            request.getRequestDispatcher("/login.jsp").forward(request, response);  
	            return;  
			}
			
		} catch (Exception e) {
			request.setAttribute("msg", "没有这个用户！");  
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
            return;  
		}
		
		//保存用户名
		String[] isRemember = request.getParameterValues("isRemember");
		if(isRemember!=null && isRemember.length>0) {
			response.setContentType("text/html;charset=UTF-8");
			//用户名保存在cookie 
			//URLEncoder解决无法在cookie中保存中文的问题
			String username1 = URLEncoder.encode(request.getParameter("username"),"utf-8");
			
			Cookie usernameCookie = new Cookie("username",username1);
			
			usernameCookie.setMaxAge(86400);//最大生存期限为1天
			
			response.addCookie(usernameCookie);
			
		} else { //如果选择不记住清空之前保存的
			Cookie[] cookies = request.getCookies();
			if(cookies!=null && cookies.length>0) {
				for(Cookie c:cookies) {
					if(c.getName().equals("username")) {
						c.setMaxAge(0); //设置cookie失效
						response.addCookie(c); //重新保存
					}
				}
			}
		}
		
	} 
	
}