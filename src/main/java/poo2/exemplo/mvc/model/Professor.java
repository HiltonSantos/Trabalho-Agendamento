package poo2.exemplo.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nome;
        
        @Column
	private String matricula;
        
        @Column
	private String disciplinas;
        
        @Column
	private String turno;

        @Column
	private String observcao;
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    
    public String getDisciplinas() {
        return disciplinas;
    }
    
    public String getTurno() {
        return turno;
    }
    
    public String getObservacao() {
        return observcao;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }

     public void setObservacao(String observacao) {
        this.observcao = observacao;
    }
    
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
        
	
	
	
}
