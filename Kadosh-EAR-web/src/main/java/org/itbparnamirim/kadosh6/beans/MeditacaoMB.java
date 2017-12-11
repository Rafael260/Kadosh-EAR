/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh6.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.itbparnamirim.kadosh.data.MeditacaoDAO;
import org.itbparnamirim.kadosh.data.MembroDAO;
import org.itbparnamirim.kadosh.model.Meditacao;
import org.itbparnamirim.kadosh.model.Membro;

/**
 *
 * @author rafao
 */
@Named
@SessionScoped
public class MeditacaoMB implements Serializable {

    private Meditacao meditacao = new Meditacao();
    private List<Meditacao> meditacoes = new ArrayList<>();
    private String novoVersiculoDeApoio = "";
    private String novaDecisao = "";

    @EJB
    MeditacaoDAO meditacaoDAO;
    
    @EJB
    MembroDAO membroDAO;

    /**
     * Creates a new instance of MeditacaoMB
     */
    public MeditacaoMB() {
    }

    public Meditacao getMeditacao() {
        return meditacao;
    }

    public void setMeditacao(Meditacao meditacao) {
        this.meditacao = meditacao;
    }

    public List<Meditacao> getMeditacoes() {
        return meditacoes;
    }

    public void setMeditacoes(List<Meditacao> meditacoes) {
        this.meditacoes = meditacoes;
    }

    public String getNovoVersiculoDeApoio() {
        return novoVersiculoDeApoio;
    }

    public void setNovoVersiculoDeApoio(String novoVersiculoDeApoio) {
        this.novoVersiculoDeApoio = novoVersiculoDeApoio;
    }

    public String getNovaDecisao() {
        return novaDecisao;
    }

    public void setNovaDecisao(String novaDecisao) {
        this.novaDecisao = novaDecisao;
    }

    public String adicionarVersiculoDeApoio() {
        this.meditacao.adicionarVersiculoDeApoio(novoVersiculoDeApoio);
        this.novoVersiculoDeApoio = "";
        ManagedBeanUtil.refresh();
        return "";
    }

    public String removerVersiculoDeApoio(String versiculoDeApoio) {
        this.meditacao.removerVersiculoDeApoio(versiculoDeApoio);
        ManagedBeanUtil.refresh();
        return "";
    }

    public String adicionarDecisao() {
        this.meditacao.adicionarDecisao(novaDecisao);
        this.novaDecisao = "";
        ManagedBeanUtil.refresh();
        return "";
    }

    public String removerDecisao(String decisao) {
        this.meditacao.removerDecisao(decisao);
        ManagedBeanUtil.refresh();
        return "";
    }

    public void limparObjetos() {
        meditacao = new Meditacao();
        novoVersiculoDeApoio = "";
        novaDecisao = "";
    }

    public void carregarLista() {
        this.meditacoes = meditacaoDAO.listar();
    }

    public String prepararCadastro() {
        limparObjetos();
        return "/pages/meditacao/cadastroMeditacao.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public String prepararEdicao(Meditacao meditacao) {
        this.meditacao = meditacao;
        return "/pages/meditacao/cadastroMeditacao.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public String prepararConsulta(Meditacao meditacao) {
        this.meditacao = meditacao;
        return "/pages/meditacao/detalharMeditacao.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public String salvar() {
        meditacaoDAO.salvar(meditacao);
        return "/pages/meditacao/exibirMeditacoes.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public String deletar(Meditacao meditacao) {
        try {
            meditacaoDAO.remover(meditacao);
        } catch (Exception ex) {
            Logger.getLogger(MeditacaoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        ManagedBeanUtil.refresh();
        return "";
    }

    public String meditar(Long idMeditacao) {
        this.meditacao = meditacaoDAO.encontrar(idMeditacao);
        HttpSession session = ManagedBeanUtil.getSession();
        session.setAttribute("meditacao", meditacao);
        return "/pages/meditacao/inicioMeditacao.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public boolean mostrarBotaoMeditacao(Meditacao meditacao){
        HttpSession session = ManagedBeanUtil.getSession();
        Membro membroLogado = (Membro) session.getAttribute("usuarioLogado");
        meditacao.setMembros(meditacaoDAO.carregarMembrosDaMeditacao(meditacao));
        membroLogado.setMeditacoes(membroDAO.getMeditacoesDoMembro(membroLogado));
        return membroLogado.naoMeditou(meditacao);
    }

}
