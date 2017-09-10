/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import excecoes.DadosInvalidosException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.itbparnamirim.kadosh.model.Disciplina;
import org.itbparnamirim.kadosh.model.Membro;

/**
 *
 * @author rafao
 */
@Local
public interface PeriodoLetivoBeanLocal {

    void validarCampos(Date dataInicio, Date dataFim, Disciplina disciplina1, Membro professor1, Disciplina disciplina2, Membro professor2) throws DadosInvalidosException;

    
}
