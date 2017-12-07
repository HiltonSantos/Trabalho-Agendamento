package poo2.exemplo.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poo2.exemplo.mvc.dao.AgendamentoDao;
import poo2.exemplo.mvc.dao.ProfessorDao;
import poo2.exemplo.mvc.dao.SalaDao;
import poo2.exemplo.mvc.dao.HoraDao;
import poo2.exemplo.mvc.model.Agendamento;
import poo2.exemplo.mvc.model.Hora;
import poo2.exemplo.mvc.model.Professor;
import poo2.exemplo.mvc.model.Sala;


@Controller
public class AgendamentoController {
	
	@Autowired
	private AgendamentoDao agendamentoDao;
        
        @Autowired
	private ProfessorDao professorDao;
        
        @Autowired
	private SalaDao salaDao;
        
        @Autowired
	private HoraDao horaDao;

	@GetMapping("/novoagendamento")
        public String novoagendamento(Model model) {
    	model.addAttribute("agendamento", new Agendamento());  
        
        List<Professor> professores = professorDao.getAll(Professor.class);
    	model.addAttribute("professores", professores);       
       
        List<Sala> salas = salaDao.getAll(Sala.class);
    	model.addAttribute("salas", salas);
        
        List<Hora> horas = horaDao.getAll(Hora.class);
    	model.addAttribute("horas", horas);
        return "novoagendamento";
        
    }
    
    @PostMapping("/salvaragendamento")
    public String salvaragendamento(
    		@ModelAttribute Agendamento agendamento, 
    		Model model) {
    	agendamentoDao.create(agendamento);
    	model.addAttribute("message", 
    			"AGENDAMENTO CRIADO COM SUCESSO!");
        return "novoagendamento";
        
    }
    
    
    @GetMapping("/listaragendamento")
    public String listaragendamento(Model model) {
    	List<Agendamento> agendamentos = agendamentoDao.getAll();
    	model.addAttribute("agendamentos", agendamentos);
        return "listaragendamento";
    }
    
   
    
    @GetMapping("/removeragendamento")
    public String removeragendamento(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Agendamento agendamentos = agendamentoDao.getById(Agendamento.class, id);
    	if(agendamentos != null)
    		agendamentoDao.delete(agendamentos);
    	model.addAttribute("message", 
    			"AGENDAMENTO REMOVIDO COM SUCESSO!");
    	List<Agendamento> agendamentoss = agendamentoDao.getAll(Agendamento.class);
    	model.addAttribute("agendamentoss", agendamentoss);
    	model.addAttribute("agendamentoPesquisa", new Agendamento());
    	return "listaragendamento";
    }

}
