import java.util.List;

public class EventSpringDao extends AbstractSpringDao{
    public EventSpringDao(){}

    public Event find(Long id){
        return (Event) super.find(Event.class, id);
    }

    public void saveOrUpdate(Event event){
        super.saveOrUpdate(event);
    }

    public void delete(Event event){
        super.delete(event);
    }

    public List findAll(){
        return super.findAll(Event.class);
    }
}
