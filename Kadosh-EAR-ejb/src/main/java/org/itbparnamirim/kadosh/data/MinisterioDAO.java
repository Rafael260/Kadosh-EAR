package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.itbparnamirim.kadosh.model.Membro;
import org.itbparnamirim.kadosh.model.Ministerio;

/**
 *
 * @author Geraldo
 */
@Stateless
public class MinisterioDAO extends TemplateDAO{

    @Inject
    MembroDAO membroDAO;
    
    public MinisterioDAO() {
    }

    public Ministerio save(Ministerio ministerio) {
        try {
//            userTransaction.begin();
            if (ministerio.getId() == null) {
                em.persist(ministerio);
            } else {
                em.merge(ministerio);
            }
//            userTransaction.commit();
        } catch (IllegalStateException | SecurityException e) {
            e.printStackTrace();
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

    public void delete(Ministerio ministerio) throws IllegalStateException, SecurityException, SystemException, Exception {
        try {
//            userTransaction.begin();
            Ministerio min = em.find(Ministerio.class, ministerio.getId());
            List<Membro> membrosDoMinisterio = membroDAO.getMembrosDoMinisterio(ministerio);
            for (Membro membro : membrosDoMinisterio) {
                membro.removerMinisterio(ministerio);
            }
            em.remove(min);
//            userTransaction.commit();
        } catch (Exception e) {
//            userTransaction.rollback();
            throw new Exception ("Houve um problema ao deletar o ministério");
        }
    }
    
}
