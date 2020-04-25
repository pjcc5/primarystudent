package cn.pjc.pojo;

import java.sql.Timestamp;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7438746155466878306L;
	private String anid;
	private String annumber;
	private String anexamnumber;
	private String anname;
	private Timestamp antime;
	private int anusetime;
	private Integer anscore;

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** minimal constructor */
	public Answer(String anid) {
		this.anid = anid;
	}

	/** full constructor */
	public Answer(String anid, String annumber, String anexamnumber,
			String anname, Timestamp antime, int anusetime,
			Integer anscore) {
		this.anid = anid;
		this.annumber = annumber;
		this.anexamnumber = anexamnumber;
		this.anname = anname;
		this.antime = antime;
		this.anusetime = anusetime;
		this.anscore = anscore;
	}

	// Property accessors

	public String getAnid() {
		return this.anid;
	}

	public void setAnid(String anid) {
		this.anid = anid;
	}

	public String getAnnumber() {
		return this.annumber;
	}

	public void setAnnumber(String annumber) {
		this.annumber = annumber;
	}

	public String getAnexamnumber() {
		return this.anexamnumber;
	}

	public void setAnexamnumber(String anexamnumber) {
		this.anexamnumber = anexamnumber;
	}

	public String getAnname() {
		return this.anname;
	}

	public void setAnname(String anname) {
		this.anname = anname;
	}

	public Timestamp getAntime() {
		return this.antime;
	}

	public void setAntime(Timestamp antime) {
		this.antime = antime;
	}

	

	public int getAnusetime() {
		return anusetime;
	}

	public void setAnusetime(int anusetime) {
		this.anusetime = anusetime;
	}

	public Integer getAnscore() {
		return this.anscore;
	}

	public void setAnscore(Integer anscore) {
		this.anscore = anscore;
	}

	@Override
	public String toString() {
		return "Answer [anid=" + anid + ", annumber=" + annumber
				+ ", anexamnumber=" + anexamnumber + ", anname=" + anname
				+ ", antime=" + antime + ", anusetime=" + anusetime
				+ ", anscore=" + anscore + "]";
	}

}