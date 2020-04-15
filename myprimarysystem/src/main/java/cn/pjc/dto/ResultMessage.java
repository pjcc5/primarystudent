package cn.pjc.dto;

import java.io.Serializable;

public class ResultMessage implements Serializable{
	private String message;
	private int flagnum;
	private boolean flag;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getFlagnum() {
		return flagnum;
	}
	public void setFlagnum(int flagnum) {
		this.flagnum = flagnum;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public ResultMessage(String message, int flagnum, boolean flag) {
		this.message = message;
		this.flagnum = flagnum;
		this.flag = flag;
	}
	

}
