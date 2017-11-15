package poo2.exemplo.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.mvc.model.Agendamento;



@Repository
@Transactional
public class AgendamentoDao extends EntityDao<Agendamento>{

	@SuppressWarnings("unchecked")
	public List<Agendamento> getByName(String nome) {
		return super.getSession()
				.createQuery("from Agendamento a "
					+ "left join fetch a.sala sa "
                                        + "left join fetch a.professor p"
					+ "where a.nome like :nome")
				.setParameter("nome", "%" + nome + "%").list();
	}
        
        public List<Agendamento> getAll() {
		return super.getSession()
				.createQuery("from Agendamento a "
					+ "left join fetch a.sala sa "
                                        + "left join fetch a.professor p"
                                        + "left join fetch a.hora h"   ).list();
	}
}
