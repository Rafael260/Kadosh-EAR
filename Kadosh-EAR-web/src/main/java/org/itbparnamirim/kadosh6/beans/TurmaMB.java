/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh6.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.itbparnamirim.kadosh.data.MembroDAO;
import org.itbparnamirim.kadosh.data.TurmaDAO;
import org.itbparnamirim.kadosh.model.Membro;
import org.itbparnamirim.kadosh.model.Turma;

/**
 *
 * @author rafao
 */
@Named
@SessionScoped
public class TurmaMB implements Serializable {

    private Turma turma = new Turma();
    private List<Turma> turmas = new ArrayList<>();
    @EJB
    TurmaDAO turmaDAO;
    @EJB
    MembroDAO membroDAO;

    /**
     * Creates a new instance of TurmaMB
     */
    public TurmaMB() {
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void carregarLista() {
        this.turmas = turmaDAO.listar();
    }

    public String prepararConsulta(Turma turma) {
        this.turma = turma;
        return "/pages/turma/detalharTurma.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public String prepararEdicao(Long id) {
        Turma turmaSelecionada = turmaDAO.encontrar(id);
        this.turma = turmaSelecionada;
        return "/pages/turma/cadastroTurma.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public String prepararCadastro() {
        limparObjetos();
        return "/pages/turma/cadastroTurma.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public void limparObjetos() {
        this.turma = new Turma();
    }

    public String deletar(Turma turma) {
        turmaDAO.remover(turma);
        ManagedBeanUtil.refresh();
        return "";
    }

    public String salvar() {
        turmaDAO.salvar(turma);
        limparObjetos();
        return "/pages/turma/exibirTurmas.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public List<Membro> completarProfessor(String nome) {
        List<Membro> professores = new ArrayList<>();
        //Carregar os membros que são professores
        List<Membro> membrosProfessores = this.membroDAO.membrosProfessores();
        for (Membro membro : membrosProfessores) {
            if (membro.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                professores.add(membro);
            }
        }
        return professores;
    }
}
