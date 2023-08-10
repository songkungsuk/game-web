package com.game.vo;

public class DrawTableVO {
	int drNum;
	String drName;
	String drDesc;
	public int getDrNum() {
		return drNum;
	}
	public void setDrNum(int drNum) {
		this.drNum = drNum;
	}
	public String getDrName() {
		return drName;
	}
	public void setDrName(String drName) {
		this.drName = drName;
	}
	public String getDrDesc() {
		return drDesc;
	}
	public void setDrDesc(String drDesc) {
		this.drDesc = drDesc;
	}
	@Override
	public String toString() {
		return "DrawTableVO [drNum=" + drNum + ", drName=" + drName + ", drDesc=" + drDesc + "]";
	}
	
	
}
