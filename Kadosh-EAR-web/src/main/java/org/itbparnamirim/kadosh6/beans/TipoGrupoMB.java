/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh6.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.itbparnamirim.kadosh.data.TipoGrupoDAO;
import org.itbparnamirim.kadosh.model.TipoGrupo;

/**
 *
 * @author rafao
 */
@Named
@SessionScoped
public class TipoGrupoMB implements Serializable{
    
    TipoGrupo tipoGrupo = new TipoGrupo();
    List<TipoGrupo> tiposGrupo = new ArrayList<>();

    @Inject TipoGrupoDAO tipoGrupoDAO;
    
    public TipoGrupo getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(TipoGrupo tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public List<TipoGrupo> getTiposGrupo() {
        return tiposGrupo;
    }

    public void setTiposGrupo(List<TipoGrupo> tiposGrupo) {
        this.tiposGrupo = tiposGrupo;
    }
    
    public void limparObjetos(){
        this.tipoGrupo = new TipoGrupo();
    }
    
     public String prepararCadastro(){
        limparObjetos();
        return "/pages/tipoGrupo/cadastroTipoGrupo.xhtml"+ManagedBeanUtil.REDIRECT;
    }
     
    public void carregarLista(){
        this.tiposGrupo = tipoGrupoDAO.listar();
    } 
    
    public String prepararEdicao(TipoGrupo tipoGrupo){
        this.tipoGrupo = tipoGrupo;
        return "/pages/tipoGrupo/cadastroTipoGrupo.xhtml"+ManagedBeanUtil.REDIRECT;
    }
    
    public String salvar(){
        tipoGrupoDAO.salvar(tipoGrupo);
        return "/pages/tipoGrupo/exibirTiposGrupo.xhtml"+ManagedBeanUtil.REDIRECT;
    }
    
    public String deletar(TipoGrupo tipoGrupo){
        try {
            tipoGrupoDAO.remover(tipoGrupo);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        ManagedBeanUtil.refresh();
        return "";
    }
}
