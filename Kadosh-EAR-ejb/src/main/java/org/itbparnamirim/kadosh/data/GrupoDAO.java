package org.itbparnamirim.kadosh.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.itbparnamirim.kadosh.model.Grupo;
import org.itbparnamirim.kadosh.model.Membro;

@Stateless
public class GrupoDAO extends AbstractDAO<Grupo> {

    //Posso fazer isso? eh para setar o grupo de cada membro como null na hora de deletar
    @Inject
    MembroDAO membroDAO;

    public GrupoDAO() {
        super(Grupo.class);
    }

    @Override
    public void remover(Grupo grupo) {
        Grupo gr = em.find(Grupo.class, grupo.getId());
        List<Membro> membrosDoGrupo = membroDAO.getMembrosDoGrupo(gr);
        for (Membro m : membrosDoGrupo) {
            m.setGrupo(null);
        }
        em.remove(gr);
    }
}
