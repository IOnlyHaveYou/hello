package com.itheima.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session1")
public class SessionServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建属于该客户端（会话）的私有的session区域
		HttpSession session = request.getSession();
		String id = session.getId();
		//手动创建一个存储JSESSIONID的Cookie为该cookie设置持久化实际那
		Cookie  cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie); 
		response.getWriter().write("JSESSIONID:"+id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
