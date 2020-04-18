package cn.pjc.pojo;

import java.sql.Timestamp;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3223603106530442517L;
	private String qid;
	private String qgrade;
	private String qtype;
	private String qsubject;
	private Timestamp qregisttime;
	private String qaid;
	private String qregister;
	private Timestamp qchangetime;
	private String qcontent;
	private String qanswera;
	private String qanswerb;
	private String qanswerc;
	private String qanswerd;
	private String qrightanswer;

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(String qid) {
		this.qid = qid;
	}

	public String getQaid() {
		return qaid;
	}

	public void setQaid(String qaid) {
		this.qaid = qaid;
	}

	/** full constructor */
	public Question(String qid, String qgrade, String qtype, String qsubject,
			Timestamp qregisttime, String qregister, Timestamp qchangetime,
			String qcontent, String qanswera, String qanswerb, String qanswerc,
			String qanswerd, String qrightanswer) {
		this.qid = qid;
		this.qgrade = qgrade;
		this.qtype = qtype;
		this.qsubject = qsubject;
		this.qregisttime = qregisttime;
		this.qregister = qregister;
		this.qchangetime = qchangetime;
		this.qcontent = qcontent;
		this.qanswera = qanswera;
		this.qanswerb = qanswerb;
		this.qanswerc = qanswerc;
		this.qanswerd = qanswerd;
		this.qrightanswer = qrightanswer;
	}

	// Property accessors

	public String getQid() {
		return this.qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getQgrade() {
		return this.qgrade;
	}

	public void setQgrade(String qgrade) {
		this.qgrade = qgrade;
	}

	public String getQtype() {
		return this.qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getQsubject() {
		return this.qsubject;
	}

	public void setQsubject(String qsubject) {
		this.qsubject = qsubject;
	}

	public Timestamp getQregisttime() {
		return this.qregisttime;
	}

	public void setQregisttime(Timestamp qregisttime) {
		this.qregisttime = qregisttime;
	}

	public String getQregister() {
		return this.qregister;
	}

	public void setQregister(String qregister) {
		this.qregister = qregister;
	}

	public Timestamp getQchangetime() {
		return this.qchangetime;
	}

	public void setQchangetime(Timestamp qchangetime) {
		this.qchangetime = qchangetime;
	}

	public String getQcontent() {
		return this.qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public String getQanswera() {
		return this.qanswera;
	}

	public void setQanswera(String qanswera) {
		this.qanswera = qanswera;
	}

	public String getQanswerb() {
		return this.qanswerb;
	}

	public void setQanswerb(String qanswerb) {
		this.qanswerb = qanswerb;
	}

	public String getQanswerc() {
		return this.qanswerc;
	}

	public void setQanswerc(String qanswerc) {
		this.qanswerc = qanswerc;
	}

	public String getQanswerd() {
		return this.qanswerd;
	}

	public void setQanswerd(String qanswerd) {
		this.qanswerd = qanswerd;
	}

	public String getQrightanswer() {
		return this.qrightanswer;
	}

	public void setQrightanswer(String qrightanswer) {
		this.qrightanswer = qrightanswer;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", qgrade=" + qgrade + ", qtype="
				+ qtype + ", qsubject=" + qsubject + ", qregisttime="
				+ qregisttime + ", qaid=" + qaid + ", qregister=" + qregister
				+ ", qchangetime=" + qchangetime + ", qcontent=" + qcontent
				+ ", qanswera=" + qanswera + ", qanswerb=" + qanswerb
				+ ", qanswerc=" + qanswerc + ", qanswerd=" + qanswerd
				+ ", qrightanswer=" + qrightanswer + "]";
	}


}