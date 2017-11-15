package poo2.exemplo.mvc.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import poo2.exemplo.mvc.model.Hora;

@Repository
@Transactional
public class HoraDao extends EntityDao<Hora>{

	@SuppressWarnings("unchecked")
	public Hora getById(String id) {
		List<Hora> horas = super.getSession().createQuery("from Hora h "
				+ "left join fetch h.hora ho "                        
				+ "where h.id = :id")
				.setParameter("id", id).list();
		if(horas.size() == 1)
			return horas.get(0);
		else
			return null;
	}
        
        
}