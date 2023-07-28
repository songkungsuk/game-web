package com.game.service.Impl;

import java.util.List;
import java.util.Map;

import com.game.repository.BoardInfoRepository;
import com.game.repository.Impl.BoardInfoRepositoryImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	BoardInfoRepository boardRepo = new BoardInfoRepositoryImpl();
	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		
		return boardRepo.selectBoardInfoList(boardInfo);
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		
		return boardRepo.selectBoardInfo(biNum);
	}

	@Override
	public int insertBoardInfo(Map<String, String> boardInfo) {
		
		return boardRepo.insertBoardInfo(boardInfo);
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		
		return boardRepo.updateBoardInfo(boardInfo);
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		
		return boardRepo.deleteBoardInfo(biNum);
	}

}
