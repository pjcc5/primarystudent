package cn.pjc.pojo;

import java.sql.Timestamp;

/**
 * Acount entity. @author MyEclipse Persistence Tools
 */

public class Acount implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 392146930765349907L;
	private String aid;
	private String aname;
	private String apass;
	private String aphoto;
	private String aphone;
	private String amail;
	private String asex;
	private Integer alevel;
	private Integer arole;
	private String acontent;
	private Timestamp acreatetime;
	private Timestamp alastchangetime;
	private Integer athumbsup;
	private String aidcardnumber;

	// Constructors

	/** default constructor */
	public Acount() {
	}

	/** minimal constructor */
	public Acount(String aid) {
		this.aid = aid;
	}

	// Property accessors

	public String getAphoto() {
		return aphoto;
	}

	public void setAphoto(String aphoto) {
		this.aphoto = aphoto;
	}

	public String getAid() {
		return this.aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApass() {
		return this.apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

	public String getAphone() {
		return this.aphone;
	}

	public void setAphone(String aphone) {
		this.aphone = aphone;
	}

	public String getAmail() {
		return this.amail;
	}

	public void setAmail(String amail) {
		this.amail = amail;
	}

	public String getAsex() {
		return this.asex;
	}

	public void setAsex(String asex) {
		this.asex = asex;
	}

	public Integer getAlevel() {
		return this.alevel;
	}

	public void setAlevel(Integer alevel) {
		this.alevel = alevel;
	}


	public Integer getArole() {
		return arole;
	}

	public void setArole(Integer arole) {
		this.arole = arole;
	}

	public String getAcontent() {
		return this.acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public Timestamp getAcreatetime() {
		return this.acreatetime;
	}

	public void setAcreatetime(Timestamp acreatetime) {
		this.acreatetime = acreatetime;
	}

	public Timestamp getAlastchangetime() {
		return this.alastchangetime;
	}

	public void setAlastchangetime(Timestamp alastchangetime) {
		this.alastchangetime = alastchangetime;
	}

	public Integer getAthumbsup() {
		return this.athumbsup;
	}

	public void setAthumbsup(Integer athumbsup) {
		this.athumbsup = athumbsup;
	}

	public String getAidcardnumber() {
		return this.aidcardnumber;
	}

	public void setAidcardnumber(String aidcardnumber) {
		this.aidcardnumber = aidcardnumber;
	}

	@Override
	public String toString() {
		return "Acount [aid=" + aid + ", aname=" + aname + ", apass=" + apass
				+ ", aphoto=" + aphoto + ", aphone=" + aphone + ", amail="
				+ amail + ", asex=" + asex + ", alevel=" + alevel + ", arole="
				+ arole + ", acontent=" + acontent + ", acreatetime="
				+ acreatetime + ", alastchangetime=" + alastchangetime
				+ ", athumbsup=" + athumbsup + ", aidcardnumber="
				+ aidcardnumber + "]";
	}


	

}