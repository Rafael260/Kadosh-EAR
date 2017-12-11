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
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.itbparnamirim.kadosh.data.EventoDAO;
import org.itbparnamirim.kadosh.model.Evento;

/**
 *
 * @author rafao
 */
@Named
@SessionScoped
public class EventoMB implements Serializable{

    private Evento evento = new Evento();
    private List<Evento> eventos = new ArrayList<>();
    @EJB EventoDAO eventoDAO;
    /**
     * Creates a new instance of EventoMB
     */
    public EventoMB() {
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public void limparObjetos(){
        evento = new Evento();
    }
    
    public void carregarLista(){
        this.eventos = eventoDAO.listar();
    }
    
    public String prepararCadastro(){
        limparObjetos();
        return "/pages/evento/cadastroEvento.xhtml"+ManagedBeanUtil.REDIRECT;
    }
    
    public String prepararEdicao(Evento evento){
        this.evento = evento;
        return "/pages/evento/cadastroEvento.xhtml"+ManagedBeanUtil.REDIRECT;
    }
    
    public String prepararConsulta(Evento evento){
        this.evento = evento;
        return "/pages/evento/detalharEvento.xhtml"+ManagedBeanUtil.REDIRECT;
    }
    
    public String salvar(){
        eventoDAO.salvar(evento);
        return "/pages/evento/exibirEventos.xhtml"+ManagedBeanUtil.REDIRECT;
    }
    
    public String deletar(Evento evento){
        eventoDAO.remover(evento);
        ManagedBeanUtil.refresh();
        return "";
    }
    
}
