package poo2.exemplo.mvc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"poo2.exemplo.mvc.main",
		"poo2.exemplo.mvc.controller", "poo2.exemplo.mvc.dao",
		"poo2.exemplo.mvc.model"
})
@EnableAutoConfiguration
public class Aula3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(Aula3Application.class);
		
		/*AlunoDao alunoDao = context.getBean(AlunoDao.class);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Joao");
		aluno1.setAtivo(true);
		aluno1.setCpf("1234567");
		aluno1.setDataInicio(new Date());
		alunoDao.create(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Maria");
		aluno2.setAtivo(true);
		aluno2.setCpf("7654321");
		aluno2.setDataInicio(new Date());
		alunoDao.create(aluno2);
		
		List<Aluno> alunos = alunoDao.getAll(Aluno.class);
		for(Aluno aluno : alunos)
			System.out.println(aluno.toString());*/
	}
}