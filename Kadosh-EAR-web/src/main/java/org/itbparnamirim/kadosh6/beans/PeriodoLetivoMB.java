/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh6.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import org.itbparnamirim.kadosh.model.Disciplina;

@ViewScoped
public class PeriodoLetivoMB {

    private int numeroDisciplinas;
    private List<Disciplina> disciplinasSelecionadas;
    
    /**
     * Creates a new instance of PeriodoLetivoMB
     */
    public PeriodoLetivoMB() {
        numeroDisciplinas = 2;
        disciplinasSelecionadas = new ArrayList<>();
    }

    public int getNumeroDisciplinas() {
        return numeroDisciplinas;
    }

    public void setNumeroDisciplinas(int numeroDisciplinas) {
        this.numeroDisciplinas = numeroDisciplinas;
    }
    
    public String selecionarTurmasAutomaticamente(){
        //Usar bean stateful para recuperar as turmas e selecionar as do próximo período letivo
        return "/pages/turma/selecionandoTurmas.xhtml"+ManagedBeanUtil.REDIRECT;
    }
}
