package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/list/*")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<Map<String, String>> MOCK_LIST = new ArrayList<Map<String,String>>();
	private static Gson gson = new Gson();
	static {
		for(int i=1; i<=100; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("num", i+"");
			map.put("name", "이름");
			map.put("age", i+"살");
			map.put("address", "한국의 이런저런곳");
			MOCK_LIST.add(map);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String json = gson.toJson(MOCK_LIST);
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
