package com.game.controller;

import java.io.BufferedReader;
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
import com.game.vo.UserInfoVO;
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
			String uiNum = request.getParameter("uiNum");
			json = gson.toJson(userSevice.selectUserInfo(uiNum));
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int result = 0;                    // 실행한 결과가 0인경우 실패 1인경우 성공
		UserInfoVO vo = new UserInfoVO(); //insert update delete  를위한 객체
		String cmd = CommonView.getcmd(request); // 요청주소의 마지막 / 이후를 잘라냄
		BufferedReader br = request.getReader(); // 요청을 읽어들임 요청페이로드를!
		StringBuffer sb = new StringBuffer(); // 스트링 버퍼에 담아냄
		String str = null; //버퍼리더로 읽은것을 담을곳
		while((str = br.readLine()) != null) { //버퍼리더로 읽은 것이 null이아닐때까지 읽음
			sb.append(str); //있으면 스트링 버퍼에 담음
		}
		System.out.println(sb.toString()); // 스트링버퍼를 string 데이터타입으로 변환함
		
		if(cmd.equals("delete")) { // 요청주소를 잘라낸것이 delete 이면
			vo.setUiNum(Integer.parseInt(sb.toString()));
			result = userSevice.deleteUserInfo(vo) ;
		}else if(cmd.equals("insert")) {
			vo = gson.fromJson(sb.toString(), UserInfoVO.class);
			result = userSevice.insertUserInfo(vo);
		}else if(cmd.equals("update")) {
			vo = gson.fromJson(sb.toString(), UserInfoVO.class);
			result = userSevice.updateUserInfo(vo);
		}

		response.setContentType("application/json; charset=UTF-8"); //json 형태로 브라우저에 출력
		PrintWriter out = response.getWriter(); // 프린터 라이터 객체생성함 브라우저에 써줄려고
		out.print(result); // 메소드 결과값을 브라우저에 쏴냄
	}

}
