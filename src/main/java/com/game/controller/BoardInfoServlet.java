package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.Impl.BoardInfoServiceImpl;


@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardInfoService boardService = new BoardInfoServiceImpl();

    public BoardInfoServlet() {
    	System.out.println("Create BoardInfoServlet Constructor");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			request.setAttribute("msg", "로그인이 필요한 화면입니다");
			request.setAttribute("url", "/");
			CommonView.forwardMsg(request, response);
			return;
		}
		String cmd = CommonView.getcmd(request);
		if(cmd.equals("list")) {
			Map<String, String> keyValue = new HashMap<String, String>();
			keyValue.put("key", request.getParameter("searchType")); 
			keyValue.put("value", request.getParameter("searchStr"));
			
			request.setAttribute("boardList", boardService.selectBoardInfoList(null));
		}
		else if(cmd.equals("view") || cmd.equals("update")) {
			String biNum = request.getParameter("biNum");
			request.setAttribute("boardOne", boardService.selectBoardInfo(biNum));
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			request.setAttribute("msg", "로그인이 필요한 화면입니다");
			request.setAttribute("url", "/");
		}
		
		request.setAttribute("msg", "작업실패");
		request.setAttribute("url", "/board-info/list");
		
		String cmd = CommonView.getcmd(request);
		Map<String, String> boardInfomation = new HashMap<>();
		Map<String, String> user = (Map<String, String>) session.getAttribute("user");
		boardInfomation.put("uiNum", user.get("uiNum"));
		boardInfomation.put("biTitle", request.getParameter("biTitle"));
		boardInfomation.put("biContent", request.getParameter("biContent"));
		if(request.getParameter("biNum") != null) {
			boardInfomation.put("biNum", request.getParameter("biNum"));
		}
		
		if(cmd.equals("insert")) {
			int result = boardService.insertBoardInfo(boardInfomation);
			if(result == 1) {
				request.setAttribute("msg", "게시물추가성공");
				
			}
		}else if (cmd.equals("update")) {
			int result = boardService.updateBoardInfo(boardInfomation);
			if(result == 1) {
				request.setAttribute("msg", "게시물수정성공");
				
			}
		}else if (cmd.equals("delete")) {
			int result = boardService.deleteBoardInfo(request.getParameter("biNum"));
			if(result == 1) {
				request.setAttribute("msg", "게시물삭제성공");
			}
		}
		
		CommonView.forwardMsg(request, response);
	}

}
