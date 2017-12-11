/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.itbparnamirim.kadosh.model.Meditacao;
import org.itbparnamirim.kadosh.model.Membro;

@Stateless
public class MeditacaoDAO extends AbstractDAO<Meditacao> {

    public MeditacaoDAO(){
        super(Meditacao.class);
    }
    
    public List<Membro> carregarMembrosDaMeditacao(Meditacao meditacao){
        TypedQuery<Membro> query;
        query = em.createQuery("select m from Membro m inner join m.meditacoes d where d = :meditacao", Membro.class);
        query.setParameter("meditacao", meditacao);
        return query.getResultList();
    }
}
