package org.itbparnamirim.kadosh.data;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.itbparnamirim.kadosh.model.Grupo;
import org.itbparnamirim.kadosh.model.Meditacao;
import org.itbparnamirim.kadosh.model.Membro;
import org.itbparnamirim.kadosh.model.Ministerio;

@Stateless
public class MembroDAO extends AbstractDAO<Membro> {

    public MembroDAO(){
        super(Membro.class);
    }
    
    public Membro autenticar(String usuario, String senha) {
        TypedQuery<Membro> query = em.createQuery("select m from Membro m where m.usuario=:usuario and m.senha=:senha", Membro.class);
        query.setParameter("usuario", usuario);
        query.setParameter("senha", senha);
        Membro membro = null;
        try {
            membro = query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Usuario/Senha inválidos");
        }
        return membro;
    }

    public List<Membro> getMembrosDoGrupo(Grupo grupo) {
        TypedQuery<Membro> query = em.createQuery("Select m from Membro m where m.grupo=:grupo", Membro.class);
        query.setParameter("grupo", grupo);
        return query.getResultList();
    }

    public List<Membro> getMembrosDoMinisterio(Ministerio ministerio) {
        TypedQuery<Membro> query;
        query = em.createQuery("select m from Membro m inner join m.ministerios d where d = :ministerio", Membro.class);
        query.setParameter("ministerio", ministerio);
        return query.getResultList();
    }

    public List<Membro> getMembrosNaoNesseMinisterio(Ministerio ministerio) {
        List<Membro> todos = listar();
        List<Membro> membrosMinisterio = getMembrosDoMinisterio(ministerio);
        List<Membro> naoDoMinisterio = new ArrayList<>();
        for (Membro membro : todos) {
            if (!membrosMinisterio.contains(membro)) {
                naoDoMinisterio.add(membro);
            }
        }
        return naoDoMinisterio;
    }

    public List<Membro> membrosLideres() {
        TypedQuery<Membro> query = em.createQuery("Select m from Membro m where m.lider = :parametroLider", Membro.class);
        query.setParameter("parametroLider", true);
        return query.getResultList();
    }

    public List<Membro> membrosProfessores() {
        TypedQuery<Membro> query = em.createQuery("Select m from Membro m where m.professor = :paramProf", Membro.class);
        query.setParameter("paramProf", true);
        return query.getResultList();
    }

    public List<Meditacao> getMeditacoesDoMembro(Membro membro) {
        TypedQuery<Meditacao> query;
        query = em.createQuery("select m from Meditacao m inner join m.membros p where p = :membro", Meditacao.class);
        query.setParameter("membro", membro);
        return query.getResultList();
    }
}
