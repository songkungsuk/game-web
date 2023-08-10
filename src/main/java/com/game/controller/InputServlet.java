package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/input/*")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StringBuffer sb = new StringBuffer();
		BufferedReader br = request.getReader();
		String str = null;
		while((str = br.readLine()) != null) {
			sb.append(str);
		}
		System.out.println(sb.toString());
		Map<String, String> myInfo = gson.fromJson(sb.toString(), Map.class);
		System.out.println(myInfo);
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String desc = request.getParameter("desc");
//		String trans = request.getParameter("trans");
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(sb.toString());
	}

}
