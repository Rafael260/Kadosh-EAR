/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Disciplina disciplina;
    
    private String anoLetivo;
    
    @OneToMany
    private List<Matricula> matriculas;
    
    @OneToOne //(fetch = FetchType.EAGER, mappedBy="turmas", cascade=CascadeType.ALL)
    private Membro professor;


    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Turma() {
    }

    public Turma(Integer id, Disciplina disciplina, String anoLetivo, List<Matricula> matriculas, Membro professor) {
        this.id = id;
        this.disciplina = disciplina;
        this.anoLetivo = anoLetivo;
        this.matriculas = matriculas;
        this.professor = professor;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public void setProfessor(Membro professor) {
        this.professor = professor;
    }
    
    public Membro getProfessor() {
        return professor;
    }

    public void setAlunos(Membro professor) {
        this.professor = professor;
    }
    
    @Override
    public String toString(){
        return this.disciplina.toString() + " - " + this.anoLetivo;
    }
    
}
