package com.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.Impl.UserInfoServiceImpl;


@WebServlet("/user-info/*") //url-pattern
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserInfoService userSevice = new UserInfoServiceImpl();

    public UserInfoServlet() {
    	System.out.println("Create UserInfoServlet Consturctor");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getcmd(request);
		if(cmd.equals("list")) {
			request.setAttribute("userList", userSevice.selectUserInfoList(null));
		}
		else if(cmd.equals("view") || cmd.equals("update")) {
			String uiNum = request.getParameter("uiNum");
			request.setAttribute("User", userSevice.selectUserInfo(uiNum));
		}
		
		CommonView.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
