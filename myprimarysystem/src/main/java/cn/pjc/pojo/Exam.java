package cn.pjc.pojo;

import java.sql.Timestamp;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */

public class Exam implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 128489104742723978L;
	private String exid;
	private String exnumber;
	private String exregister;
	private Timestamp exregisttime;
	private Integer exlimittime;

	// Constructors

	/** default constructor */
	public Exam() {
	}

	/** minimal constructor */
	public Exam(String exid) {
		this.exid = exid;
	}

	/** full constructor */
	public Exam(String exid, String exnumber, String exregister,
			Timestamp exregisttime, Integer exlimittime) {
		this.exid = exid;
		this.exnumber = exnumber;
		this.exregister = exregister;
		this.exregisttime = exregisttime;
		this.exlimittime = exlimittime;
	}

	// Property accessors

	public String getExid() {
		return this.exid;
	}

	public void setExid(String exid) {
		this.exid = exid;
	}

	public String getExnumber() {
		return this.exnumber;
	}

	public void setExnumber(String exnumber) {
		this.exnumber = exnumber;
	}

	public String getExregister() {
		return this.exregister;
	}

	public void setExregister(String exregister) {
		this.exregister = exregister;
	}

	public Timestamp getExregisttime() {
		return this.exregisttime;
	}

	public void setExregisttime(Timestamp exregisttime) {
		this.exregisttime = exregisttime;
	}

	public Integer getExlimittime() {
		return this.exlimittime;
	}

	public void setExlimittime(Integer exlimittime) {
		this.exlimittime = exlimittime;
	}

	@Override
	public String toString() {
		return "Exam [exid=" + exid + ", exnumber=" + exnumber
				+ ", exregister=" + exregister + ", exregisttime="
				+ exregisttime + ", exlimittime=" + exlimittime + "]";
	}

}