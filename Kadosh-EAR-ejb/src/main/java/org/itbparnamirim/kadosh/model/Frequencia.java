package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Geraldo Jr
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Frequencia extends AbstractModel implements Serializable{
    
    @Temporal(TemporalType.DATE)
    private Date dataAula;
    private boolean presenca;
    
    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    public Date getData() {
        return dataAula;
    }

    public void setData(Date data) {
        this.dataAula = data;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
}
