package poo2.exemplo.mvc.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.mvc.model.Disciplina;

@Repository
@Transactional
public class DisciplinaDao extends EntityDao<Disciplina>{

}