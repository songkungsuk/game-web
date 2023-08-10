package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.BoardInfoVO;

public interface BoardInfoService {
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO boardInfo);
	BoardInfoVO selectBoardInfo(String biNum);
	int insertBoardInfo(Map<String, String> boardInfo);
	int updateBoardInfo(Map<String, String> boardInfo);
	int deleteBoardInfo(String biNum);
}
