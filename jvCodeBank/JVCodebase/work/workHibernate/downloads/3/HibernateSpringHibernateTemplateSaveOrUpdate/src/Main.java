
import java.util.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;

import org.hibernate.*;
import org.hibernate.criterion.*;

public class Main {
	
	
	public static void main(String[] args) {
		HibernateUtil.setup("create table EVENTS ( uid int, name VARCHAR, start_Date date, duration int);");
		
		// hibernate code start
        HibernateFactory.buildSessionFactory();
        SessionFactory sessionFactory= HibernateFactory.getSessionFactory();
        HibernateTemplate template= new HibernateTemplate(sessionFactory);


        Event event = new Event();
        event.setName("Spring Hibernate Template");
        template.saveOrUpdate(event);
        Event obj = (Event) template.load(Event.class, event.getId());

        HibernateUtil.checkData("select uid, name from events");        

        HibernateFactory.closeFactory();
        
		// hibernate code end
	}
	
}