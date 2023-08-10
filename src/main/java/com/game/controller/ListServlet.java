package com.game.controller;

import java.io.BufferedReader;
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
import com.google.gson.Gson;

@WebServlet("/list/*")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<Map<String, String>> MOCK_LIST = new ArrayList<Map<String, String>>();
	private static Gson gson = new Gson();
	static {
		for (int i = 1; i <= 100; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("num", i + "");
			map.put("name", "이름");
			map.put("age", i + "살");
			map.put("address", "한국의 이런저런곳");
			MOCK_LIST.add(map);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = CommonView.getcmd(request);
		String json = "";
		if (cmd.equals("list")) {
			json = gson.toJson(MOCK_LIST);
		} else if (cmd.equals("one") || cmd.equals("update")) {
			for (Map<String, String> var : MOCK_LIST) {
				if (var.get("num").equals(request.getParameter("num"))) {
					json = gson.toJson(var);
					break;
				}
			}

		} else {
			json = "이상한접근경로로 왔습니다";
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String json = "0";
		BufferedReader br = request.getReader(); // request(요청)객체를 읽어 버퍼리더에 넣는다
		StringBuffer sb = new StringBuffer(); // 스트링버퍼 객체 생성
		String str = null; // 스트링 널로 초기화
		while ((str = br.readLine()) != null) { // str에 br.readLine을 대입한것이 널이아니면 스트링버퍼에 str을 추가한다
			sb.append(str);
		}

		String cmd = CommonView.getcmd(request);

		if (cmd.equals("insert")) { // 이중에 함정이있음
			Map<String, String> map = gson.fromJson(sb.toString(), Map.class);
			System.out.println(map);
			map.put("num", MOCK_LIST.size() + 1 + "");
			if (MOCK_LIST.add(map)) {
				json = "1";
			}

		} else if (cmd.equals("delete")) { // 이중에 함정이 있음
			String num = request.getParameter("num");
			System.out.println(num);
			if (MOCK_LIST.remove(Integer.parseInt(num) - 1) != null) {
				json = "1";
			}
		} else if (cmd.equals("update")) {
			Map<String, String> map = gson.fromJson(sb.toString(), Map.class);
			String num = request.getParameter("num");
			map.put("num", num);
			System.out.println(map);
			for (int i = 0; i < MOCK_LIST.size() - 1; i++) {
				if (map.get("num").equals(MOCK_LIST.get(i).get("num"))) {
					MOCK_LIST.set(i, map);
					json = "1";
					break;
				}
			}

		}

		System.out.println(json);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print(json);
	}

}
