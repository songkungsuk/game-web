package com.game.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.DrawTableMapper;
import com.game.service.DrawTableService;
import com.game.vo.DrawTableVO;

public class DrawTableServiceImpl implements DrawTableService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<DrawTableVO> getDrawTable(DrawTableVO draw) {
		try (SqlSession session = ssf.openSession()){
			DrawTableMapper dtMapper = session.getMapper(DrawTableMapper.class);
			return dtMapper.getDrawTable(null);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
