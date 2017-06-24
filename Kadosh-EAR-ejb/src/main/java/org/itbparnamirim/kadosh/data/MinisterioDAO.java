package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import org.itbparnamirim.kadosh.model.Membro;
import org.itbparnamirim.kadosh.model.Ministerio;

/**
 *
 * @author Geraldo
 */
@Stateless
public class MinisterioDAO extends TemplateDAO {

    @Inject
    MembroDAO membroDAO;

    public MinisterioDAO() {
    }

    public Ministerio save(Ministerio ministerio) {
        if (ministerio.getId() == null) {
            em.persist(ministerio);
        } else {
            em.merge(ministerio);
        }
        return ministerio;
    }

    public List<Ministerio> list() {
        TypedQuery<Ministerio> query = em.createNamedQuery("findAllMinisterios", Ministerio.class);
        List<Ministerio> ministerios = query.getResultList();
        for (Ministerio ministerio : ministerios) {
            ministerio.setMembrosMinisterio(membroDAO.getMembrosDoMinisterio(ministerio));
        }
        return ministerios;
    }

    public void delete(Ministerio ministerio) {
        Ministerio min = em.find(Ministerio.class, ministerio.getId());
        List<Membro> membrosDoMinisterio = membroDAO.getMembrosDoMinisterio(ministerio);
        for (Membro membro : membrosDoMinisterio) {
            membro.removerMinisterio(ministerio);
        }
        em.remove(min);
    }

}
