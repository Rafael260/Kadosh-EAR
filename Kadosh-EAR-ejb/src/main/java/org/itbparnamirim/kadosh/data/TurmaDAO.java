package org.itbparnamirim.kadosh.data;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.itbparnamirim.kadosh.model.Membro;
import org.itbparnamirim.kadosh.model.Turma;

/**
 *
 * @author Geraldo
 */
@Stateless
public class TurmaDAO extends AbstractDAO<Turma> {

    public TurmaDAO() {
        super(Turma.class);
    }

    public List<Membro> buscarProfessorPorNome(String nome) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Membro> criteriaQuery = builder.createQuery(Membro.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Membro> membroRoot = criteriaQuery.from(Membro.class);

        if (StringUtils.isNotBlank(nome)) {
            predicates.add(builder.equal(membroRoot.get("nome"), nome));
        }

        if (StringUtils.isNotBlank(nome)) {
            predicates.add(builder.like(membroRoot.<String>get("nome"),
                    "%" + nome.toLowerCase() + "%"));
        }
        criteriaQuery.select(membroRoot);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Membro> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
