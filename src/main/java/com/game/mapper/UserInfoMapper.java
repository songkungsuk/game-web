package com.game.mapper;

import java.util.List;

import com.game.vo.UserInfoVO;

public interface UserInfoMapper {
	List<UserInfoVO> selectUserInfoList(UserInfoVO user);

	UserInfoVO selectUserInfo(String uiNum);

	int insertUserInfo(UserInfoVO user);

	int updateUserInfo(UserInfoVO user);

	int deleteUserInfo(UserInfoVO user);

}
