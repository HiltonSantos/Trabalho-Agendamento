package poo2.exemplo.mvc.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import poo2.exemplo.mvc.model.Professor;
import poo2.exemplo.mvc.model.Sala;

@Repository
@Transactional
public class EntityDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void create(T entidade) {
		getSession().persist(entidade);
		return;
	}

	public void delete(T entidade) {
		if (getSession().contains(entidade))
			getSession().delete(entidade);
		else
			getSession().delete(getSession().merge(entidade));
		return;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> cls) {
		return getSession().createQuery("from " + cls.getName()).list();
	}

	public T getById(Class<T> cls, long id) {
		return getSession().load(cls, id);
	}

	public void update(Sala sala) {
		getSession().merge(sala);
		return;
	}
        
        public void update(Professor professor) {
		getSession().merge(professor);
		return;
	}
}