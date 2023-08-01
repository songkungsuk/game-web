package com.game.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {
	private final static String PREFIX = "/WEB-INF/views";
	private final static String SUFFIX = ".jsp";
	public static String getcmd(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.lastIndexOf("/") +1); 
	}
	public static void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = PREFIX + request.getRequestURI() + SUFFIX;
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public static void forwardMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/common/message.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
