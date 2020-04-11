package cn.pjc.pojo;

/**
 * Answerquestion entity. @author MyEclipse Persistence Tools
 */

public class Answerquestion implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8861106298537740845L;
	private String aqid;
	private String aqnumber;
	private String aqquestionid;
	private String aqanswer;

	// Constructors

	/** default constructor */
	public Answerquestion() {
	}

	/** minimal constructor */
	public Answerquestion(String aqid) {
		this.aqid = aqid;
	}

	/** full constructor */
	public Answerquestion(String aqid, String aqnumber, String aqquestionid,
			String aqanswer) {
		this.aqid = aqid;
		this.aqnumber = aqnumber;
		this.aqquestionid = aqquestionid;
		this.aqanswer = aqanswer;
	}

	// Property accessors

	public String getAqid() {
		return this.aqid;
	}

	public void setAqid(String aqid) {
		this.aqid = aqid;
	}

	public String getAqnumber() {
		return this.aqnumber;
	}

	public void setAqnumber(String aqnumber) {
		this.aqnumber = aqnumber;
	}

	public String getAqquestionid() {
		return this.aqquestionid;
	}

	public void setAqquestionid(String aqquestionid) {
		this.aqquestionid = aqquestionid;
	}

	public String getAqanswer() {
		return this.aqanswer;
	}

	public void setAqanswer(String aqanswer) {
		this.aqanswer = aqanswer;
	}

	@Override
	public String toString() {
		return "Answerquestion [aqid=" + aqid + ", aqnumber=" + aqnumber
				+ ", aqquestionid=" + aqquestionid + ", aqanswer=" + aqanswer
				+ "]";
	}

}