package com.game.service;

import java.util.List;

import com.game.vo.DrawTableVO;

public interface DrawTableService {
	List<DrawTableVO> getDrawTable(DrawTableVO draw);
}
