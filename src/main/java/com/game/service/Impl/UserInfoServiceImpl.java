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
	public Map<String, String> selectUserInfo(String uiNum) {
		
		return urRepo.selectUserInfo(uiNum);
	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		
		return urRepo.selectUserInfoById(uiId);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		
		return urRepo.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		
		return urRepo.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		
		return urRepo.deleteUserInfo(uiNum);
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

}
