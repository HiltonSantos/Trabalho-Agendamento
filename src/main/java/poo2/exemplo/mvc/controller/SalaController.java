package poo2.exemplo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poo2.exemplo.mvc.dao.SalaDao;
import poo2.exemplo.mvc.model.Sala;

@Controller
public class SalaController {
	
	@Autowired
	private SalaDao salaDao;

	@GetMapping("/novasala")
    public String novasala(Model model) {
    	model.addAttribute("sala", new Sala());
        return "novasala";
    }
    
    @PostMapping("/salvarsala")
    public String salvarsala(
    		@ModelAttribute Sala sala, 
    		Model model) {
    	salaDao.create(sala);
    	model.addAttribute("message", 
    			"Sala criado com sucesso!");
        return "novasala";
    }
    
    @GetMapping("/listasalas")
    public String listarsala(Model model) {
    	List<Sala> salas = salaDao.getAll(Sala.class);
    	model.addAttribute("salas", salas);
        return "listasalas";
    }
}
