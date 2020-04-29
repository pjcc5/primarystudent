package cn.pjc.dto;

import java.sql.Timestamp;

import cn.pjc.pojo.Answerquestion;
import cn.pjc.pojo.Question;

public class QuestionResultDto {

	private static final long serialVersionUID = -6838607041885640789L;
	
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
	private String useranswer;
	
	private boolean isright=false;//题目是否正确

	public QuestionResultDto(Question question)
	{
		this(question,false,"");
	}
	public QuestionResultDto(Question question,boolean isright,String useranswer){
		this.isright = isright;
		this.qaid = question.getQaid();
		this.qanswera = question.getQanswera();
		this.qanswerb = question.getQanswerb();
		this.qanswerc = question.getQanswerc();
		this.qanswerd = question.getQanswerd();
		this.qchangetime = question.getQchangetime();
		this.qcontent = question.getQcontent();
		this.qgrade = question.getQgrade();
		this.qid = question.getQid();
		this.qregister = question.getQregister();
		this.qregisttime =question.getQregisttime();
		this.qrightanswer = question.getQrightanswer();
		this.qsubject = question.getQsubject();
		this.qtype = question.getQtype();
		this.useranswer = useranswer;
	}
	
	


	public String getUseranswer() {
		return useranswer;
	}
	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}
	public boolean getIsright() {
		return isright;
	}
	public void setIsright(boolean isright) {
		this.isright = isright;
	}


	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQgrade() {
		return qgrade;
	}
	public void setQgrade(String qgrade) {
		this.qgrade = qgrade;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getQsubject() {
		return qsubject;
	}
	public void setQsubject(String qsubject) {
		this.qsubject = qsubject;
	}
	public Timestamp getQregisttime() {
		return qregisttime;
	}
	public void setQregisttime(Timestamp qregisttime) {
		this.qregisttime = qregisttime;
	}
	public String getQaid() {
		return qaid;
	}
	public void setQaid(String qaid) {
		this.qaid = qaid;
	}
	public String getQregister() {
		return qregister;
	}
	public void setQregister(String qregister) {
		this.qregister = qregister;
	}
	public Timestamp getQchangetime() {
		return qchangetime;
	}
	public void setQchangetime(Timestamp qchangetime) {
		this.qchangetime = qchangetime;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQanswera() {
		return qanswera;
	}
	public void setQanswera(String qanswera) {
		this.qanswera = qanswera;
	}
	public String getQanswerb() {
		return qanswerb;
	}
	public void setQanswerb(String qanswerb) {
		this.qanswerb = qanswerb;
	}
	public String getQanswerc() {
		return qanswerc;
	}
	public void setQanswerc(String qanswerc) {
		this.qanswerc = qanswerc;
	}
	public String getQanswerd() {
		return qanswerd;
	}
	public void setQanswerd(String qanswerd) {
		this.qanswerd = qanswerd;
	}
	public String getQrightanswer() {
		return qrightanswer;
	}
	public void setQrightanswer(String qrightanswer) {
		this.qrightanswer = qrightanswer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "QuestionResultDto [qid=" + qid + ", qgrade=" + qgrade
				+ ", qtype=" + qtype + ", qsubject=" + qsubject
				+ ", qregisttime=" + qregisttime + ", qaid=" + qaid
				+ ", qregister=" + qregister + ", qchangetime=" + qchangetime
				+ ", qcontent=" + qcontent + ", qanswera=" + qanswera
				+ ", qanswerb=" + qanswerb + ", qanswerc=" + qanswerc
				+ ", qanswerd=" + qanswerd + ", qrightanswer=" + qrightanswer
				+ ", useranswer=" + useranswer + ", isright=" + isright + "]";
	}


	
	
	
	
	
	
}
