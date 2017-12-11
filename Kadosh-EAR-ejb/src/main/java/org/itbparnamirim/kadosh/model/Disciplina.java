/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NamedQuery(name = "findAllDisciplinas", query = "SELECT d FROM Disciplina d")
public class Disciplina extends AbstractModel implements Serializable {
    
    private String nome;
    private String sigla;
    private String ciclo;
    
    @OneToMany
    private List<Turma> turmas;

    public Disciplina() {
        turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    
    @Override
    public String toString(){
        return this.sigla + " - " + this.nome + " ciclo: "+ this.ciclo;
    }
    
    @Override
    public boolean equals(Object outra){
        if (!(outra instanceof Disciplina)){
            return false;
        }
        Disciplina outraDisciplina = (Disciplina) outra;
        return this == outraDisciplina || this.getId().equals(outraDisciplina.getId());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
}
