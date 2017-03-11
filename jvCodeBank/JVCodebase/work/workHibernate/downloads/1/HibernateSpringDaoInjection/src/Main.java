
import java.util.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.sql.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

public class Main {
	
	
	public static void main(String[] args) {
		HibernateUtil.setup("create table EVENTS ( uid int, name VARCHAR, start_Date date, duration int);");
		
		// hibernate code start

        EventSpringDao eventDao = null;
        Event event = new Event();
        event.setName("Name");

        eventDao = DaoRegistry.getEventDao();
        eventDao.saveOrUpdate(event);

        
        HibernateUtil.checkData("select uid, name from events");        

        
		// hibernate code end
	}
	
}