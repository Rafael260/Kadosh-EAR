package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import org.itbparnamirim.kadosh.model.Evento;

@Stateless
public class EventoDAO extends TemplateDAO {

    public EventoDAO() {

    }

    //Eh importante usar o mesmo metodo para inserir e atualizar para conseguir aproveitar a tela de cadastro para fazer edicoes
    public Evento save(Evento evento) {
        if (evento.getId() == null) {
            em.persist(evento);
        } else {
            em.merge(evento);
        }
        return evento;
    }

    public List<Evento> list() {
        TypedQuery<Evento> query = em.createQuery("Select e from Evento e", Evento.class);
        return query.getResultList();
    }

    public Evento find(Integer id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento){
        Evento ev = em.find(Evento.class, evento.getId());
        em.remove(ev);
    }
}
