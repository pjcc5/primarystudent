package cn.pjc.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pjc.pojo.Acount;
import cn.pjc.util.IDHelper;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SqlSessionFactory factory =(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		System.out.println(factory.openSession());
		Acount acount = new Acount();
		acount.setAid(IDHelper.getUUID() );
		
		SqlSession session = factory.openSession();
		int result = session.insert("cn.pjc.mapper.AcountMapper.saveAcount",acount);
		System.out.println(result);
		session.commit();

	}

}
