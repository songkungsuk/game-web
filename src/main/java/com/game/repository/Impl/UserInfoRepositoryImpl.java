package com.game.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBcon;
import com.game.repository.UserInfoRepository;

public class UserInfoRepositoryImpl implements UserInfoRepository {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		String sql ="SELECT * FROM USER_INFO";
		List<Map<String, String>> users = new ArrayList<>();
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> map = new HashMap();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						
						users.add(map);
					}
				}
			}
		} catch (Exception e) {

		}
		return users;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql ="SELECT * FROM USER_INFO WHERE UI_NUM = ?";
		Map<String, String> map = new HashMap<>();
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						
						return map;
					}
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql ="SELECT * FROM USER_INFO WHERE UI_ID = ?";
		Map<String, String> map = new HashMap<>();
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiId);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						
						return map;
					}
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql ="INSERT INTO USER_INFO(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?, ?, ?, ?, DATE_FORMAT(NOW(), '%Y%m%d'),  DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'),  DATE_FORMAT(NOW(), '%H%i%s'))";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps =  con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql ="UPDATE user_info SET UI_NAME = ?, UI_ID=?, UI_PWD=?, UI_IMG_PATH=?, UI_DESC=?, UI_BIRTH=?, LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'), LMOTIM = DATE_FORMAT(NOW(), '%H%i%s') \r\n"
				+ "WHERE UI_NUM = ?";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps =  con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				ps.setString(7, userInfo.get("uiNum"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql ="DELETE FROM user_info WHERE UI_NUM=?";
		try (Connection con = DBcon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiNum);
				
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserInfoRepository userInfo = new UserInfoRepositoryImpl();
		Map<String, String> user = new HashMap<>();
		user.put("uiName", "songsong2");
		user.put("uiId", "song3744");
		user.put("uiPwd", "1234");
		user.put("uiImgPath", null);
		user.put("uiDesc", "myinfo");
		user.put("uiBirth", "19970829");
		user.put("uiNum", "8");
		
//		System.out.println(userInfo.insertUserInfo(user));
//		System.out.println(userInfo.updateUserInfo(user));
//		System.out.println(userInfo.deleteUserInfo("3"));
		System.out.println(userInfo.selectUserInfo("3"));
		System.out.println(userInfo.selectUserInfoList(null));
		System.out.println(userInfo.selectUserInfoById("hongsong"));
		
	}
}
