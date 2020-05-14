package cn.pjc.util;

import java.io.Serializable;
import java.util.Properties;

public class EmailEntity implements Serializable {
	 //邮箱的配置信息
    private Properties properties;
    //邮箱用户名
    private String userName;
    //邮箱密码
    private String password;
    //主题
    private String subject;
    //邮件内容
    private String text;
    //发件人
    private String from;
    //收件人
    private String to;
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
    
}
