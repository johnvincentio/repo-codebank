import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public abstract class AbstractSpringDao  extends HibernateDaoSupport{

    public AbstractSpringDao() { }

    protected void saveOrUpdate(Object obj) {
        getHibernateTemplate().saveOrUpdate(obj);
    }

    protected void delete(Object obj) {
        getHibernateTemplate().delete(obj);
    }

    protected Object find(Class clazz, Long id) {
        return getHibernateTemplate().load(clazz, id);
    }

    protected List findAll(Class clazz) {
        return getHibernateTemplate().find("from " + clazz.getName());
    }
}
