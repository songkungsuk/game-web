package com.game.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.BoardInfoMapper;
import com.game.repository.BoardInfoRepository;
import com.game.repository.Impl.BoardInfoRepositoryImpl;
import com.game.service.BoardInfoService;
import com.game.vo.BoardInfoVO;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoRepository boardRepo = new BoardInfoRepositoryImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO boardInfo) {
		
		try (SqlSession session = ssf.openSession(true)){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.boardInfoList(boardInfo);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public BoardInfoVO selectBoardInfo(String biNum) {
		try(SqlSession session = ssf.openSession(true)){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.boardInfo(biNum);
		}catch (Exception e) {
			throw e;
		}
		
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
