package poo2.exemplo.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poo2.exemplo.mvc.dao.ProfessorDao;
import poo2.exemplo.mvc.model.Professor;


@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorDao professorDao;

	@GetMapping("/novoprofessor")
    public String novoprofessor(Model model) {
    	model.addAttribute("professor", new Professor());
        return "novoprofessor";
    }
    
    @PostMapping("/salvarprofessor")
    public String salvarprofessor(
    		@ModelAttribute Professor professor, 
    		Model model) {
    	professorDao.create(professor);
    	model.addAttribute("message", 
    			"Professor criado com sucesso!");
        return "novoprofessor";
    }
    
    @GetMapping("/listaprofessor")
    public String listarprofessor(Model model) {
    	List<Professor> professores = professorDao.getAll(Professor.class);
    	model.addAttribute("professores", professores);
        return "listaprofessor";
        
    }
    
    @GetMapping("/editarprofessor")
    public String editarprofessor(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Professor professor = professorDao.getById(Professor.class, id);
    	model.addAttribute("professor", professor);
    	
    	List<Professor> professore = professorDao.getAll(Professor.class);
    	model.addAttribute("professore", professore);
        return "novoprofessor";
    }
    
    @GetMapping("/removerprofessor")
    public String removerprofessor(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Professor professore = professorDao.getById(Professor.class, id);
    	if(professore != null)
    		professorDao.delete(professore);
    	model.addAttribute("message", 
    			"Professor removido com sucesso!");
    	List<Professor> professores = professorDao.getAll(Professor.class);
    	model.addAttribute("professores", professores);
    	model.addAttribute("professorPesquisa", new Professor());
    	return "listaprofessor";
    }

}
