package poo2.exemplo.mvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {

  

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nome;
	
	@Column
	private String vagas;
        
        @Column
	private String progInstalados ;
        
        @Column
	private String status;
        
        @Column
	private String observacao;

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

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    

    /**
     * @return the progInstalados
     */
    public String getProgInstalados() {
        return progInstalados;
    }

    /**
     * @param progInstalados the progInstalados to set
     */
    public void setProgInstalados(String progInstalados) {
        this.progInstalados = progInstalados;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
  /**
     * @return the vagas
     */
    public String getVagas() {
        return vagas;
    }
    
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param vagas the vagas to set
     */
    public void setVagas(String vagas) {
        this.vagas = vagas;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
	
        
	
}