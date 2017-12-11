/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author rafao
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class TipoGrupo extends AbstractModel implements Serializable {
 
    @Column(unique=true)
    private String nomeTipo;
    
    public TipoGrupo(){
        
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }
    
    @Override
    public String toString(){
        return this.nomeTipo;
    }
}
