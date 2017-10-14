package poo2.exemplo.mvc.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.mvc.model.Professor;

@Repository
@Transactional
public class ProfessorDao extends EntityDao<Professor>{

}