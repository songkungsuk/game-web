package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;

@WebServlet("/calc/*")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("op");
		if (type.equals("+")) {
			result = num1 + num2;
			out.write("<h1> 두수의 합은 : " + result + " </h1>");

		} else if(type.equals("-")){
			result = num1 - num2;
			out.write("<h1> 두수의 차는 : " + result + " </h1>");
		} else if(type.equals("*")){
			result = num1 * num2;
			out.write("<h1> 두수의 곱은 : " + result + " </h1>");
		} else if(type.equals("/")){
			result = num1 / num2;
			out.write("<h1> 두수의 나누기는 : " + result + " </h1>");
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
