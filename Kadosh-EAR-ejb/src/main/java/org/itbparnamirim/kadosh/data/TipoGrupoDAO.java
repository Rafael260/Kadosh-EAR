/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.data;

import javax.ejb.Stateless;
import org.itbparnamirim.kadosh.model.TipoGrupo;

/**
 *
 * @author rafao
 */
@Stateless
public class TipoGrupoDAO extends AbstractDAO<TipoGrupo>{
    
    public TipoGrupoDAO(){
        super(TipoGrupo.class);
    }
    
}
