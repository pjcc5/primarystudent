package cn.pjc.pojo;

/**
 * Examdetail entity. @author MyEclipse Persistence Tools
 */

public class Examdetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -306152859106250869L;
	private String exdid;
	private String exdnumber;
	private String exdgrade;
	private String exdsubject;
	private String exdtype;
	private Short exdamount;

	// Constructors

	/** default constructor */
	public Examdetail() {
	}

	/** minimal constructor */
	public Examdetail(String exdid) {
		this.exdid = exdid;
	}

	/** full constructor */
	public Examdetail(String exdid, String exdnumber, String exdgrade,
			String exdsubject, String exdtype, Short exdamount) {
		this.exdid = exdid;
		this.exdnumber = exdnumber;
		this.exdgrade = exdgrade;
		this.exdsubject = exdsubject;
		this.exdtype = exdtype;
		this.exdamount = exdamount;
	}

	// Property accessors

	public String getExdid() {
		return this.exdid;
	}

	public void setExdid(String exdid) {
		this.exdid = exdid;
	}

	public String getExdnumber() {
		return this.exdnumber;
	}

	public void setExdnumber(String exdnumber) {
		this.exdnumber = exdnumber;
	}

	public String getExdgrade() {
		return this.exdgrade;
	}

	public void setExdgrade(String exdgrade) {
		this.exdgrade = exdgrade;
	}

	public String getExdsubject() {
		return this.exdsubject;
	}

	public void setExdsubject(String exdsubject) {
		this.exdsubject = exdsubject;
	}

	public String getExdtype() {
		return this.exdtype;
	}

	public void setExdtype(String exdtype) {
		this.exdtype = exdtype;
	}

	public Short getExdamount() {
		return this.exdamount;
	}

	public void setExdamount(Short exdamount) {
		this.exdamount = exdamount;
	}

	@Override
	public String toString() {
		return "Examdetail [exdid=" + exdid + ", exdnumber=" + exdnumber
				+ ", exdgrade=" + exdgrade + ", exdsubject=" + exdsubject
				+ ", exdtype=" + exdtype + ", exdamount=" + exdamount + "]";
	}

}