package com.game.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBcon;
import com.game.repository.BoardInfoRepository;

public class BoardInfoRepositoryImpl implements BoardInfoRepository {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		String sql = "SELECT BI.*, UI.UI_NAME FROM board_info BI INNER JOIN user_info UI ON BI.UI_NUM = UI.UI_NUM WHERE 1=1 ";
		List<Map<String, String>> boardList = new ArrayList<>();
		if (boardInfo.get("value") != null) {
			String key = boardInfo.get("key");
			if (key.equals("1")) {
				sql += "AND BI_TITLE LIKE CONCAT('%',?,'%')";
			} else if (key.equals("2")) {
				sql += "AND (UI_NAME LIKE CONCAT('%',?,'%'))";
			} else if (key.equals("3")) {
				sql += "AND (BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if (key.equals("4")) {
				sql += "AND (BI_TITLE LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if (key.equals("5")) {
				sql += "AND (UI_NAME LIKE CONCAT('%',?,'%') OR BI_TITLE LIKE CONCAT('%',?,'%'))";
			} else if (key.equals("6")) {
				sql += "AND (BI_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%'))";
			} else if (key.equals("7")) {
				sql += "AND (BI_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			}
		}
		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				if (boardInfo.get("value") != null) {
					String key = boardInfo.get("key");
					if (key.equals("1")) {
						ps.setString(1, boardInfo.get("value"));
					} else if (key.equals("2")) {
						ps.setString(1, boardInfo.get("value"));
					} else if (key.equals("3")) {
						ps.setString(1, boardInfo.get("value"));
					} else if (key.equals("4")) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if (key.equals("5")) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if (key.equals("6")) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					} else if (key.equals("7")) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
						ps.setString(3, boardInfo.get("value"));
					}

				}
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> map = new HashMap<>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("uiName", rs.getString("UI_NAME"));

						boardList.add(map);
					}
				}
			}
		} catch (Exception e) {

		}
		return boardList;
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql = "SELECT * FROM board_info WHERE BI_NUM=?";

		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Map<String, String> map = new HashMap<>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
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
	public int insertBoardInfo(Map<String, String> boardInfo) {
		String sql = "INSERT INTO board_info(BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?,?,?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo.get("biTitle"));
				ps.setString(2, boardInfo.get("biContent"));
				ps.setString(3, boardInfo.get("uiNum"));

				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		String sql = "UPDATE board_info SET BI_TITLE=?, BI_CONTENT=?, UI_NUM=?, LMODAT=DATE_FORMAT(NOW(), '%Y%m%d'), LMOTIM = DATE_FORMAT(NOW(), '%H%i%s') WHERE BI_NUM = ?;";
		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo.get("biTitle"));
				ps.setString(2, boardInfo.get("biContent"));
				ps.setString(3, boardInfo.get("uiNum"));
				ps.setString(4, boardInfo.get("biNum"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM board_info WHERE BI_NUM = ?";
		try (Connection con = DBcon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				return ps.executeUpdate();
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public static void main(String[] args) {
		BoardInfoRepository boards = new BoardInfoRepositoryImpl();
		Map<String, String> map = new HashMap<>();
		map.put("biTitle", "hot!!");
		map.put("biContent", "very hot outside");
		map.put("uiNum", "4");
		map.put("biNum", "10");
		Map<String, String> keyValue = new HashMap<String, String>();
		keyValue.put("key", "BI_CONTENT");
		keyValue.put("value", "m");
//		System.out.println(boards.insertBoardInfo(map));
//		System.out.println(boards.updateBoardInfo(map));
//		System.out.println(boards.deleteBoardInfo("11"));
		System.out.println(boards.selectBoardInfoList(keyValue));
//		System.out.println(boards.selectBoardInfo("11"));
	}
}
