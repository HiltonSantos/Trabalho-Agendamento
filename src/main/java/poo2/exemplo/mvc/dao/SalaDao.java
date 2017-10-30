package poo2.exemplo.mvc.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import poo2.exemplo.mvc.model.Sala;

@Repository
@Transactional
public class SalaDao extends EntityDao<Sala>{

	@SuppressWarnings("unchecked")
	public Sala getByCpf(String id) {
		List<Sala> salas = super.getSession().createQuery("from Sala a "
				+ "left join fetch a.nome mt "
				+ "left join fetch mt.quantidade q "
				+ "where a.id = :id")
				.setParameter("id", id).list();
		if(salas.size() == 1)
			return salas.get(0);
		else
			return null;
	}
}