/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.itbparnamirim.kadosh.model.AbstractModel;

/**
 *
 * @author rafao
 * @param <T> Tipo do dado a ser mantido
 */
public abstract class AbstractDAO<T extends AbstractModel> {

    @PersistenceContext(unitName = "kadosh6PU")
    protected EntityManager em;
    protected Class<T> classe;

    public AbstractDAO(Class<T> classe) {
        this.classe = classe;
    }

    public T salvar(T entity){
        if(entity.getId() == null){
            em.persist(entity);
        }
        else{
            em.merge(entity);
        }
        return entity;
    }

    public void remover(T entity) {
        Long id = entity.getId();
        T e = encontrar(id);
        em.remove(e);
    }

    public List<T> listar() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(classe);
        query.from(classe);
        return em.createQuery(query).getResultList();
    }

    public T encontrar(Long id) {
        return em.find(classe, id);
    }
    
    public boolean conexaoAberta(){
        return em.isOpen();
    }
    
    public void fecharConexao(){
        if(conexaoAberta()){
            em.close();
            System.out.println("Fechando conexao");
        }
    }
}