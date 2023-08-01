package com.game.common;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.BoardInfoMapper;
import com.game.vo.BoardInfoVO;

public class MybatisSqlSessionFactory {

	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";

	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}

	public static void main(String[] args) {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession(true);
		BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
		
		BoardInfoVO bi = new BoardInfoVO();
		bi.setBiNum(15);
		bi.setBiTitle("안녕하세요");
		bi.setBiContent("인사입니다");
		bi.setUiNum(14);
		
		List<BoardInfoVO> selectList = biMapper.selectBoardInfoList(null);
		BoardInfoVO boardVO = biMapper.selectBoardInfo(bi);
//		int result = biMapper.insertBoardInfo(bi);
		int result = biMapper.updateBoardInfo(bi);
//		int result = biMapper.deleteBoardInfo(bi);
		System.out.println(result);
		
		
//		System.out.println(boardVO);
		
		for(BoardInfoVO board : selectList) {
			System.out.println(board);
		}
	}
}
