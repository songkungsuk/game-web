package com.game.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.vo.UserInfoVO;

public interface UserInfoService {
	List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);

	UserInfoVO selectUserInfo(String uiNum);

	Map<String, String> selectUserInfoById(String uiId);

	int insertUserInfo(UserInfoVO user);

	int updateUserInfo(UserInfoVO user);

	int deleteUserInfo(UserInfoVO UserInfoVO);
	
	boolean checkLogin(Map<String, String> userInfo , HttpSession session);
}
