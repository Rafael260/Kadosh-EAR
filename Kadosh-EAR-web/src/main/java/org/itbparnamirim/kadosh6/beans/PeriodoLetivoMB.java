/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh6.beans;

import excecoes.DadosInvalidosException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.itbparnamirim.kadosh.ejb.PeriodoLetivoBeanLocal;
import org.itbparnamirim.kadosh.model.Disciplina;
import org.itbparnamirim.kadosh.model.Membro;

@SessionScoped
public class PeriodoLetivoMB implements Serializable {

    private String periodoLetivo;
    private Date dataInicio;
    private Date dataFim;
    private Disciplina disciplina1;
    private Membro professor1;
    private Disciplina disciplina2;
    private Membro professor2;

    @EJB
    PeriodoLetivoBeanLocal periodoLetivoBean;

    /**
     * Creates a new instance of PeriodoLetivoMB
     */
    public PeriodoLetivoMB() {
    }

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Disciplina getDisciplina1() {
        return disciplina1;
    }

    public void setDisciplina1(Disciplina disciplina1) {
        this.disciplina1 = disciplina1;
    }

    public Membro getProfessor1() {
        return professor1;
    }

    public void setProfessor1(Membro professor1) {
        this.professor1 = professor1;
    }

    public Disciplina getDisciplina2() {
        return disciplina2;
    }

    public void setDisciplina2(Disciplina disciplina2) {
        this.disciplina2 = disciplina2;
    }

    public Membro getProfessor2() {
        return professor2;
    }

    public void setProfessor2(Membro professor2) {
        this.professor2 = professor2;
    }

    public String irParaMatricula() {
        String paginaDestino = "/pages/turma/matriculas.xhtml";
        try {
            periodoLetivoBean.validarCampos(dataInicio, dataFim, disciplina1, professor1, disciplina2, professor2);
        } catch (DadosInvalidosException ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            String mensagemErro = ex.getLocalizedMessage();
            String[] erros = mensagemErro.split("-");
            for (String erro : erros) {
                FacesMessage mensagem = new FacesMessage(
                        erro);
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }

            paginaDestino = "";
        }
        //Realizar validação usando regras de negocio, no caso, nao pode selecionar a mesma disciplina e o mesmo professor
        return paginaDestino;
    }

}
