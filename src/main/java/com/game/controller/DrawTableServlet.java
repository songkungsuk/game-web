package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.DrawTableService;
import com.game.service.Impl.DrawTableServiceImpl;
import com.google.gson.Gson;


@WebServlet("/draw-table/*")
public class DrawTableServlet extends HttpServlet {
	private DrawTableService dtService = new DrawTableServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getcmd(request);
		String json = "";
		if(cmd.equals("list")) {
			json = gson.toJson(dtService.getDrawTable(null));
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
