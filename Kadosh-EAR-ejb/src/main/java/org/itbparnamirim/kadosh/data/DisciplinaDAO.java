/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.data;

import javax.ejb.Stateless;
import org.itbparnamirim.kadosh.model.Disciplina;

@Stateless
public class DisciplinaDAO extends AbstractDAO<Disciplina>{
    
    public DisciplinaDAO(){
        super(Disciplina.class);
    }
}
