/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import org.itbparnamirim.kadosh.model.Disciplina;

/**
 *
 * @author rafao
 */
@Stateful
public class PeriodoLetivoBean implements PeriodoLetivoBeanLocal {

    private List<Disciplina> disciplinas = new ArrayList<>();
    private Date dataInicialPeriodo;
    private Date dataFinalPeriodo;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Disciplina> getDisciplinasParaPeriodoLetivo(Integer qtdeDisciplinas) {
        return null;
    }
    
}
