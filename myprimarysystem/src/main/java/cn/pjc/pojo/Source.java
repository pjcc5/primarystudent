package cn.pjc.pojo;

import java.sql.Timestamp;

/**
 * Source entity. @author MyEclipse Persistence Tools
 */

public class Source implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4317590867146507020L;
	private String sid;
	private String sname;
	private Integer stype;
	private String spublisher;
	private Timestamp spublishtime;
	private Timestamp schangetime;
	private String surl;
	private String remark;
	private Integer sdownloadtimes;

	// Constructors

	/** default constructor */
	public Source() {
	}

	/** minimal constructor */
	public Source(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Source(String sid, String sname, Integer stype, String spublisher,
			Timestamp spublishtime, Timestamp schangetime, String surl,
			String remark, Integer sdownloadtimes) {
		this.sid = sid;
		this.sname = sname;
		this.stype = stype;
		this.spublisher = spublisher;
		this.spublishtime = spublishtime;
		this.schangetime = schangetime;
		this.surl = surl;
		this.remark = remark;
		this.sdownloadtimes = sdownloadtimes;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getStype() {
		return this.stype;
	}

	public void setStype(Integer stype) {
		this.stype = stype;
	}

	public String getSpublisher() {
		return this.spublisher;
	}

	public void setSpublisher(String spublisher) {
		this.spublisher = spublisher;
	}

	public Timestamp getSpublishtime() {
		return this.spublishtime;
	}

	public void setSpublishtime(Timestamp spublishtime) {
		this.spublishtime = spublishtime;
	}

	public Timestamp getSchangetime() {
		return this.schangetime;
	}

	public void setSchangetime(Timestamp schangetime) {
		this.schangetime = schangetime;
	}

	public String getSurl() {
		return this.surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSdownloadtimes() {
		return this.sdownloadtimes;
	}

	public void setSdownloadtimes(Integer sdownloadtimes) {
		this.sdownloadtimes = sdownloadtimes;
	}

	@Override
	public String toString() {
		return "Source [sid=" + sid + ", sname=" + sname + ", stype=" + stype
				+ ", spublisher=" + spublisher + ", spublishtime="
				+ spublishtime + ", schangetime=" + schangetime + ", surl="
				+ surl + ", remark=" + remark + ", sdownloadtimes="
				+ sdownloadtimes + "]";
	}

}