package poo2.exemplo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    
    @GetMapping("/CadastroSala")
    public String sala() {
        return "CadastroSala";
    }
    
    @GetMapping("/CadastroProfessor")
    public String prof() {
        return "CadastroProfessor";
    }
}
