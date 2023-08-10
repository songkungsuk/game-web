package com.game.service.Impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.UserInfoMapper;
import com.game.repository.UserInfoRepository;
import com.game.repository.Impl.UserInfoRepositoryImpl;
import com.game.service.UserInfoService;
import com.game.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoRepository urRepo = new UserInfoRepositoryImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo) {
		try (SqlSession session=ssf.openSession()){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfoList(userInfo);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public UserInfoVO selectUserInfo(String uiNum) {
		SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = ssf.openSession(true);
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		
		return uiMapper.selectUserInfo(uiNum);
	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		
		return urRepo.selectUserInfoById(uiId);
	}

	@Override
	public int insertUserInfo(UserInfoVO user) {
		SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = ssf.openSession(true);
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		return uiMapper.insertUserInfo(user);
	}

	@Override
	public int updateUserInfo(UserInfoVO user) {
		SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = ssf.openSession(true);
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		
		return uiMapper.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(UserInfoVO user) {
		SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession session = ssf.openSession(true);
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		
		return uiMapper.deleteUserInfo(user);
	}

	@Override
	public boolean checkLogin(Map<String, String> userInfo, HttpSession session) {
		String userId = userInfo.get("uiId"); //사용자가 입력한 아이디
		String urpw = urRepo.selectUserInfoById(userId).get("uiPwd"); //데이터베이스에있는 아이디
		
		if(userId != null) {
			if(userInfo.get("uiPwd").equals(urpw)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		UserInfoService urService = new UserInfoServiceImpl();
		// UI_NAME='a', UI_ID='b', UI_PWD='c', UI_DESC='d' WHERE UI_NUM = 1
		UserInfoVO vo = new UserInfoVO();
		vo.setUiName("d");
		vo.setUiId("cdasdsa");
		vo.setUiPwd("b");
		vo.setUiDesc("a");
		vo.setUiNum(1);
//		System.out.println(urService.selectUserInfo("1"));
		
//		System.out.println(urService.insertUserInfo(vo));
//		System.out.println(urService.updateUserInfo(vo));
		System.out.println(urService.deleteUserInfo(vo));
		System.out.println(urService.selectUserInfoList(null));
	}
}
