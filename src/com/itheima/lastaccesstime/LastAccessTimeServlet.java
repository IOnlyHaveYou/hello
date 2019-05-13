package com.itheima.lastaccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lastAccessTime")
public class LastAccessTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//获取当前的时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String currentTime = format.format(date);
		//1.创建一个cookie 记录当前的最新的访问时间
		Cookie cookie = new Cookie("lastAccessTime", currentTime);
		cookie.setMaxAge(60*10*500);
		response.addCookie(cookie);
		 
		//2.获得客户端携带的cookie---lastAccessTime
		String lastAccessTime = null;
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie coo : cookies) {
				if ("lastAccessTime".equals(coo.getName())) {
					lastAccessTime = coo.getValue();
					
				}
		}
			}
		response.setContentType("text/html;charaset=UTF-8");
		if(lastAccessTime ==null) {
			response.getWriter().write("您是第一次访问");
		}else {
			response.getWriter().write("您上次的访问时间是："+lastAccessTime);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
