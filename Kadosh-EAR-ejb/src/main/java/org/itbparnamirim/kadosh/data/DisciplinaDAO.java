/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.itbparnamirim.kadosh.model.Disciplina;

@Stateless
public class DisciplinaDAO extends TemplateDAO {

    public Disciplina save(Disciplina disciplina) throws NotSupportedException {
        if (disciplina.getId() == null) {
            em.persist(disciplina);
        } else {
            em.merge(disciplina);
        }
        return disciplina;
    }

    public List<Disciplina> list() {
        TypedQuery<Disciplina> query = em.createNamedQuery("findAllDisciplinas", Disciplina.class);
        List<Disciplina> disciplinas = query.getResultList();
        return disciplinas;
    }

    public void delete(Disciplina disciplina){
        Disciplina d = em.find(Disciplina.class, disciplina.getId());
        em.remove(d);
    }
}
