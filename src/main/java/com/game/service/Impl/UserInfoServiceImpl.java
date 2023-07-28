package com.game.service.Impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.repository.UserInfoRepository;
import com.game.repository.Impl.UserInfoRepositoryImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoRepository urRepo = new UserInfoRepositoryImpl();
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		
		return urRepo.selectUserInfoList(userInfo);
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
