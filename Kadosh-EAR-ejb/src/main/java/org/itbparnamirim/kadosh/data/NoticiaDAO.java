package org.itbparnamirim.kadosh.data;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.itbparnamirim.kadosh.model.Noticia;

@Stateless
public class NoticiaDAO extends TemplateDAO {

    public NoticiaDAO() {

    }

    //Eh importante usar o mesmo metodo para inserir e atualizar para conseguir aproveitar a tela de cadastro para fazer edicoes
    public Noticia save(Noticia noticia) {
        if (noticia.getId() == null) {
            em.persist(noticia);
        } else {
            em.merge(noticia);
        }
        return noticia;
    }

    public List<Noticia> list() {
        TypedQuery<Noticia> query = em.createNamedQuery("findAllNoticias", Noticia.class);
        return query.getResultList();
    }

    public Noticia find(Integer id) {
        return em.find(Noticia.class, id);
    }

    public void delete(Noticia noticia){
        Noticia not = em.find(Noticia.class, noticia.getId());
        em.remove(not);
    }

    public List<Noticia> carregarAtivas() {
        List<Noticia> noticiasAtivas;
        Date dataAtual = new Date(System.currentTimeMillis());
        TypedQuery<Noticia> query = em.createQuery("SELECT n FROM Noticia n WHERE n.validade > :dataAtual", Noticia.class);
        query.setParameter("dataAtual", dataAtual);
        noticiasAtivas = query.getResultList();
        return noticiasAtivas;
    }
}
