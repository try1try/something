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
		//��֤��¼
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("validationCode");
		String saveCode = (String)request.getSession().getAttribute("check_code");
		PrintWriter out = response.getWriter();
		//�����֤���Ƿ���ȷ
		if(!saveCode.equalsIgnoreCase(checkCode)) {
			request.setAttribute("msg", "��֤�����");  
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
            return;  
		}
		//����û��Ƿ����
		UserDao userDao = new UserDao();
		User user = new User();
		try {
			user = userDao.get(username);
			if(password.equals(user.getPassword())) {
				//out.println("����,"+ user.getUsername());
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				session.setAttribute("email", user.getEmail());
				response.sendRedirect(request.getContextPath()+"/DisplayServlet");
			}else {
				request.setAttribute("msg", "���벻��ȷ��");  
	            request.getRequestDispatcher("/login.jsp").forward(request, response);  
	            return;  
			}
			
		} catch (Exception e) {
			request.setAttribute("msg", "û������û���");  
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
            return;  
		}
		
		//�����û���
		String[] isRemember = request.getParameterValues("isRemember");
		if(isRemember!=null && isRemember.length>0) {
			response.setContentType("text/html;charset=UTF-8");
			//�û���������cookie 
			//URLEncoder����޷���cookie�б������ĵ�����
			String username1 = URLEncoder.encode(request.getParameter("username"),"utf-8");
			
			Cookie usernameCookie = new Cookie("username",username1);
			
			usernameCookie.setMaxAge(86400);//�����������Ϊ1��
			
			response.addCookie(usernameCookie);
			
		} else { //���ѡ�񲻼�ס���֮ǰ�����
			Cookie[] cookies = request.getCookies();
			if(cookies!=null && cookies.length>0) {
				for(Cookie c:cookies) {
					if(c.getName().equals("username")) {
						c.setMaxAge(0); //����cookieʧЧ
						response.addCookie(c); //���±���
					}
				}
			}
		}
		
	} 
	
}