package poo2.exemplo.mvc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private boolean ativo;

	@Column(name = "data_inicio", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Matricula matricula;
	
	public Aluno(){
		this.matricula = new Matricula();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public String toString(){
		return "Nome: " + this.nome + " - CPF: " + this.cpf + 
					" - DataInicio: " + this.dataInicio + 
					" - Ativo: " + this.ativo + " - Matricula: " + this.matricula.getId();
	}
}