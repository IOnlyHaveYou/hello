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

import com.sun.corba.se.spi.copyobject.CopierManager;

@WebServlet("/LastAccessTimeServlet2")
public class LastAccessTimeServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前时间
		Date date = new Date();
		//转换输出格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		//将当前的时间设置为想要的格式
		String currentTim = format.format(date);
		//创建cookie对象
		Cookie cookie = new Cookie("lastAccessTime", currentTim);
		//设置cookie持久化
		cookie.setMaxAge(60*10*500);
		//将cookie加入到响应中
		response.addCookie(cookie);
		//创建一个String类型的变量并等于null
		String lastAccessTime = null;
		//获取cookie中的数据
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie coo : cookies) {
				if ("lastAccessTime".equals(coo.getName())) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		//解决中文乱码问题
		response.setContentType("text/html;charaset=UTF-8");
		//如果lostAccessTime为null，那么说明是第一次访问，
		if(lastAccessTime ==null) {
		response.getWriter().write("您是第一次访问本网站");
		}else{
			response.getWriter().write("您上次的访问时间是："+lastAccessTime);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
