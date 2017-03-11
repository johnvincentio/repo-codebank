
import java.util.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.*;
import org.hibernate.criterion.*;

public class Main {
	
	
	public static void main(String[] args) {
		HibernateUtil.setup("create table EVENTS ( uid int, name VARCHAR, start_Date date, duration int);");
		
		// hibernate code start

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        SessionFactory sf = (SessionFactory) ctx.getBean("factory", SessionFactory.class);

        Session session = sf.openSession();
        Event e = new Event();
        e.setName("Name");
        session.save(e);
        session.flush();
        HibernateUtil.checkData("select uid, name from events");        
        
        session.delete(e);
        
        session.close();
        

        
		// hibernate code end
	}
	
}