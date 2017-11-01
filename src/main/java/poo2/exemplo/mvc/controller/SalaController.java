package poo2.exemplo.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/editarsala")
    public String editarsala(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Sala sala2 = salaDao.getById(Sala.class, id);
    	model.addAttribute("sala2", sala2);
    	
    	List<Sala> sala01 = salaDao.getAll(Sala.class);
    	model.addAttribute("sala01", sala01);
        return "novasala";
    }
    
    @GetMapping("/removersala")
    public String removersala(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Sala salas = salaDao.getById(Sala.class, id);
    	if(salas != null)
    		salaDao.delete(salas);
    	model.addAttribute("message", 
    			"Sala removido com sucesso!");
    	List<Sala> salass = salaDao.getAll(Sala.class);
    	model.addAttribute("salass", salass);
    	model.addAttribute("salaPesquisa", new Sala());
    	return "listasalas";
    }

}
