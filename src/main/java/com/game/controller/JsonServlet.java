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

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.Impl.BoardInfoServiceImpl;
import com.game.vo.BoardInfoVO;
import com.google.gson.Gson;

@WebServlet("/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Gson gson = new Gson();
	static BoardInfoService biService = new BoardInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = "";
		String cmd = CommonView.getcmd(request);
		if (cmd.equals("list")) {
			BoardInfoVO boardinfo = new BoardInfoVO();
			boardinfo.setSearchStr(request.getParameter("searchStr"));
			boardinfo.setSearchType(request.getParameter("searchType"));
			json = gson.toJson(biService.selectBoardInfoList(boardinfo));
		}else if(cmd.equals("one")) {
			String biNum = request.getParameter("biNum");
			json = gson.toJson(biService.selectBoardInfo(biNum));
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public static void main(String[] args) {
		BoardInfoVO boardinfo = new BoardInfoVO();
		List<BoardInfoVO> biList = biService.selectBoardInfoList(boardinfo);
		String json = gson.toJson(biList);
		System.out.println(json);
	}
}
