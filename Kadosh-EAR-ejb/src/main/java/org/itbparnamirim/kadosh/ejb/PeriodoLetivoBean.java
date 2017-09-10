/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import excecoes.DadosInvalidosException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import org.itbparnamirim.kadosh.model.Disciplina;
import org.itbparnamirim.kadosh.model.Membro;

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
    public void validarCampos(Date dataInicio, Date dataFim, Disciplina disciplina1, Membro professor1, Disciplina disciplina2, Membro professor2) throws DadosInvalidosException {
        
        String mensagem = "";
        if (disciplina1.equals(disciplina2)){
//            throw new DadosInvalidosException("Devem ter duas disciplinas distintas no período letivo");
            mensagem += "Devem ter duas disciplinas distintas no período letivo - ";
        }
        if (professor1.equals(professor2)){
//            throw new DadosInvalidosException("Um professor é responsável por apenas uma turma por período letivo");
            mensagem += "Um professor é responsável por apenas uma turma por período letivo - ";
        }
        if(dataInicio == null || dataFim == null){
            mensagem += "Os campos de data início e data fim não podem ser nulos";
        }
        else if (dataInicio.after(dataFim)){
//            throw new DadosInvalidosException("Data início deve ser antes da data fim");
            mensagem += "Data início deve ser antes da data fim";
        }
        if (!mensagem.isEmpty()){
            throw new DadosInvalidosException(mensagem);
        }
    }

}
