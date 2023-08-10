package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.Impl.UserInfoServiceImpl;
import com.google.gson.Gson;

@WebServlet("/user-info/*") // url-pattern
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoService userSevice = new UserInfoServiceImpl();
	private Gson gson = new Gson();
	
	public UserInfoServlet() {
		System.out.println("Create UserInfoServlet Consturctor");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonView.getcmd(request);
		String json = "";
		if (cmd.equals("list")) {
			json = gson.toJson(userSevice.selectUserInfoList(null));
		} else if (cmd.equals("view") || cmd.equals("update")) {
			
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getcmd(request);

		request.setAttribute("msg", "작업실패");
		request.setAttribute("url", "/user-info/list");

		Map<String, String> getUser = new HashMap<>();
		if (request.getParameter("uiNum") != null) {
			getUser.put("uiNum", request.getParameter("uiNum"));
		}
		getUser.put("uiName", request.getParameter("uiName"));
		getUser.put("uiId", request.getParameter("uiId"));
		getUser.put("uiPwd", request.getParameter("uiPwd"));
		getUser.put("uiImgPath", request.getParameter("uiImgPath"));
		getUser.put("uiDesc", request.getParameter("uiDesc"));
		getUser.put("uiBirth", request.getParameter("uiBirth"));

		if (cmd.equals("insert")) {
			int result = userSevice.insertUserInfo(getUser);
			if (result == 1) {
				request.setAttribute("msg", "유저 추가 성공");
				request.setAttribute("url", "/");
			}
		} else if (cmd.equals("update")) {
			int result = userSevice.updateUserInfo(getUser);
			if (result == 1) {
				request.setAttribute("msg", "유저 수정 성공");
			}
		} else if (cmd.equals("delete")) {
			int result = userSevice.deleteUserInfo(request.getParameter("uiNum"));
			if (result == 1) {
				request.setAttribute("msg", "유저 삭제 성공");
			}
		} else if(cmd.equals("login")) {
			HttpSession session = request.getSession();
			boolean login = userSevice.checkLogin(getUser, session);
			if(login) {
				request.setAttribute("msg", "로그인성공");
				request.setAttribute("url", "/");
				session.setAttribute("user", userSevice.selectUserInfoById(request.getParameter("uiId")));
			}
		}

		CommonView.forwardMsg(request, response);
	}

}
