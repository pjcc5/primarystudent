package cn.pjc.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pjc.pojo.Answer;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SqlSessionFactory factory =(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		System.out.println(factory.openSession());
//		Acount acount = new Acount();
//		acount.setAid(IDHelper.getUUID() );
		
		//插入Answer
		//Answer a = new Answer(IDHelper.getUUID());
		
		
		SqlSession session = factory.openSession();
		Answer an = session.selectOne("cn.pjc.mapper.AnswerMapper.selectAnswerByAnid", "3cbc0215bd9b44738eb12bbc6592038f");
		System.out.println(an);
		//int result = session.insert("cn.pjc.mapper.AcountMapper.saveAcount",acount);
		//int result = session.insert("cn.pjc.mapper.AnswerMapper.saveAnswer",a);
		int result = session.delete("cn.pjc.mapper.AnswerMapper.deleteAnswerByAnid","3cbc0215bd9b44738eb12bbc6592038f");
		System.out.println(result);
		session.commit();

	}

}
