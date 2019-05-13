package com.itheima.cookie;

import java.io.IOException;
import java.util.logging.ConsoleHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendCookieServlet")
public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.创建cookie对象
		Cookie cookie = new Cookie("name", "zhangsan");
		//1.1为cookie设置持久化时间---cookie信息在硬盘上保存的时间
		cookie.setMaxAge(10*60);//10分钟
		
		//1.2为cookie设置携带的路径
		cookie.setPath("/WEB16/sendCookieServlet");
		//2.将cookie中存储的信息发送到客户端----响应头
		response.addCookie(cookie);
		//
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
