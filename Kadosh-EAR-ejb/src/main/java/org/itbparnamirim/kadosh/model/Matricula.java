package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Geraldo Jr
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Matricula extends AbstractModel implements Serializable{

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro aluno;
    
    private BigDecimal nota;
    
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    
    @OneToMany
    private List<Frequencia> frequencia;

    public Membro getAluno() {
        return aluno;
    }

    public void setAluno(Membro aluno) {
        this.aluno = aluno;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Frequencia> getAssiduidade() {
        return frequencia;
    }

    public void setAssiduidade(List<Frequencia> frequencia) {
        this.frequencia = frequencia;
    }
    
}
