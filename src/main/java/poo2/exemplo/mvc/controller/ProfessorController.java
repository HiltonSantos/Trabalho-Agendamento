package poo2.exemplo.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
}
