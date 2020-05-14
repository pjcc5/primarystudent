package cn.pjc.util;



import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.util.StringUtils;

public class SendMailUtils {
	
	 public static void SendMail(final EmailEntity entity) {
		 
	        try {
	            Authenticator authenticator = new Authenticator() {
	                private PasswordAuthentication authentication;
	 
	                {
	                    authentication = new PasswordAuthentication(entity.getUserName(), entity.getPassword());
	                }
	 
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return authentication;
	                }
	            };
	 
	            Session session = Session.getInstance(entity.getProperties(), authenticator);
	 
	            Message msg = new MimeMessage(session);
	 
	            msg.setSubject(entity.getSubject());
	 
	            msg.setText(entity.getText());
	 
	 
	            msg.setFrom(new InternetAddress(entity.getFrom()));
	 
	            Transport transport = session.getTransport();
	 
	 
	            transport.send(msg, new Address[]{new InternetAddress(entity.getTo())});
	 
	            transport.close();
	 
	            //System.out.println("邮件发送成功");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	    }
}
