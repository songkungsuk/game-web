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
		bi.setBiNum(26);
		bi.setBiTitle("안녕하세요");
		bi.setBiContent("인사입니다zz");
		bi.setUiNum(14);
//		System.out.println(biMapper.boardInfo(bi));
		
		int result = biMapper.deleteBoardInfo(bi);
		System.out.println(result);
		List<BoardInfoVO> boardInfoList = biMapper.boardInfoList(null);
		for(BoardInfoVO board : boardInfoList) {
			System.out.println(board);
		}
	}
}
