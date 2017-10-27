package poo2.exemplo.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.mvc.model.Professor;

@Repository
@Transactional
public class ProfessorDao extends EntityDao<Professor>{

	@SuppressWarnings("unchecked")
	public Professor getByCpf(String id) {
		List<Professor> profs = super.getSession().createQuery("from Professor a "
				+ "left join fetch a.nome "
				
				+ "where a.id = :id")
				.setParameter("id", id).list();
		if(profs.size() == 1)
			return profs.get(0);
		else
			return null;
	}
}