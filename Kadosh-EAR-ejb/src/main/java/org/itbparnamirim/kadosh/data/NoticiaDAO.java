package org.itbparnamirim.kadosh.data;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.itbparnamirim.kadosh.model.Noticia;

@Stateless
public class NoticiaDAO extends AbstractDAO<Noticia> {

    public NoticiaDAO() {
        super(Noticia.class);
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
