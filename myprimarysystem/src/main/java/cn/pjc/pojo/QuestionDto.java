package cn.pjc.pojo;

public class QuestionDto {
	private int classificationcount;//这种分类的题数
	private String classificationname;//分类名称
	
	public int getClassificationcount() {
		return classificationcount;
	}

	public void setClassificationcount(int classificationcount) {
		this.classificationcount = classificationcount;
	}

	public String getClassificationname() {
		return classificationname;
	}

	public void setClassificationname(String classificationname) {
		this.classificationname = classificationname;
	}

	@Override
	public String toString() {
		return "QuestionDto [classificationcount=" + classificationcount
				+ ", classificationname=" + classificationname + "]";
	}
	

}
