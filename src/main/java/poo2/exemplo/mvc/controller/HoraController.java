package poo2.exemplo.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poo2.exemplo.mvc.dao.HoraDao;
import poo2.exemplo.mvc.model.Hora;


@Controller
public class HoraController {
	
	@Autowired
	private HoraDao horaDao;

    
 
    @GetMapping("/novahora")
    public String novahora(Model model) {
    	model.addAttribute("hora", new Hora());
        return "novahora";
    }
    
    @PostMapping("/salvarhora")
    public String salvarhora(
    		@ModelAttribute Hora hora, 
    		Model model) {
    	horaDao.create(hora);
    	model.addAttribute("message", 
    			"hora criado com sucesso!");
        return "novahora";
        
    }
    
    
    @GetMapping("/listahora")
    public String listarhora(Model model) {
    	List<Hora> horas = horaDao.getAll(Hora.class);
    	model.addAttribute("horas", horas);
        return "listahora";
    }
    
   
    
    @GetMapping("/removerhora")
    public String removerhora(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Hora horas = horaDao.getById(Hora.class, id);
    	if(horas != null)
    		horaDao.delete(horas);
    	model.addAttribute("message", 
    			"Hora removido com sucesso!");
    	List<Hora> horass = horaDao.getAll(Hora.class);
    	model.addAttribute("horass", horass);
    	
    	return "listahora";
    }
    

}
