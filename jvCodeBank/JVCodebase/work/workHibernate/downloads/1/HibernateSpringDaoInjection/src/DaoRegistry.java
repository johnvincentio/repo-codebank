
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.SessionFactory;

public class DaoRegistry {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("context.xml");
    }

    /**
     * Private to make this a singleton.
     */
    private DaoRegistry(){

    }

    public static SessionFactory getSessionFactory(){
        return (SessionFactory) ctx.getBean("factory", SessionFactory.class);
    }

    public static EventSpringDao getEventDao(){
        return (EventSpringDao)ctx.getBean("eventDao", EventSpringDao.class);
    }
}
