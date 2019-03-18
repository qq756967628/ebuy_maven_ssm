package com.lcvc.ebuy_maven_ssm.web.backstage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//HttpSession session=request.getSession();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		HttpSession session=request.getSession();
		AdminDao adminDao=new AdminDao();
		
//		String name="admin";
//		String pass="123";
		
		//获取登录页面的账号名表单数据
		String username=request.getParameter("username");
		session.setAttribute("user", username);
		//获取登录页面的密码表单数据
		String password=request.getParameter("password");
	
		if(adminDao.login(username, password)){
			response.sendRedirect(basePath+"/Jsp/backstage/main.html");
		}else{
			response.sendRedirect(basePath+"/Jsp/backstage/login.jsp");
		}

	}

}
