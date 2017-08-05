/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import java.util.List;
import javax.ejb.Local;
import org.itbparnamirim.kadosh.model.Disciplina;

/**
 *
 * @author rafao
 */
@Local
public interface PeriodoLetivoBeanLocal {

    List<Disciplina> getDisciplinasParaPeriodoLetivo(Integer qtdeDisciplinas);
    
}
