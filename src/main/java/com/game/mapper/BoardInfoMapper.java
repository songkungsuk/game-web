package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfoVO;

public interface BoardInfoMapper {
	List<BoardInfoVO> boardInfoList(BoardInfoVO board);
	BoardInfoVO boardInfo(String biNum);
	int insertBoardInfo(BoardInfoVO board);
	int updateBoardInfo(BoardInfoVO board);
	int deleteBoardInfo(BoardInfoVO board);
	
}
