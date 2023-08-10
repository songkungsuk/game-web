package com.game.mapper;

import java.util.List;

import com.game.vo.DrawTableVO;

public interface DrawTableMapper {
	List<DrawTableVO> getDrawTable(DrawTableVO draw);
}
