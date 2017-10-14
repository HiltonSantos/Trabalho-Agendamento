package poo2.exemplo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poo2.exemplo.mvc.dao.AlunoDao;
import poo2.exemplo.mvc.model.Aluno;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDao alunoDao;

	@GetMapping("/novoaluno")
    public String novoaluno(Model model) {
    	model.addAttribute("aluno", new Aluno());
        return "novoaluno";
    }
    
    @PostMapping("/salvaraluno")
    public String salvaraluno(
    		@ModelAttribute Aluno aluno, 
    		Model model) {
    	alunoDao.create(aluno);
    	model.addAttribute("message", 
    			"Aluno criado com sucesso!");
        return "novoaluno";
    }
    
    @GetMapping("/listaralunos")
    public String listaralunos(Model model) {
    	List<Aluno> alunos = alunoDao.getAll(Aluno.class);
    	model.addAttribute("alunos", alunos);
        return "listaralunos";
    }
}
