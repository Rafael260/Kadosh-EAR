/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh6.beans;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.itbparnamirim.kadosh.data.MembroDAO;
import org.itbparnamirim.kadosh.model.Membro;

/**
 *
 * @author rafao
 */
@Named
@SessionScoped
public class LoginMB implements Serializable {

    private Membro membroLogado;
    private String usuario;
    private String senha;

    @EJB
    MembroDAO membroDAO;

    public LoginMB() {
    }

    public Membro getMembroLogado() {
        return membroLogado;
    }

    public void setMembroLogado(Membro membroLogado) {
        this.membroLogado = membroLogado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String entrar() {
        membroLogado = membroDAO.autenticar(usuario, senha);
        if (membroLogado != null) {
            HttpSession session = ManagedBeanUtil.getSession();
            session.setAttribute("usuarioLogado", membroLogado);
            return "/pages/dashboardAdmin.xhtml" + ManagedBeanUtil.REDIRECT;
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    "Usuário/senha inválidos!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            senha = "";
            return null;
        }
    }
        

    public String sair() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "/login.xhtml" + ManagedBeanUtil.REDIRECT;
    }

    public boolean usuarioLogado() {
        return membroLogado != null;
    }
}
