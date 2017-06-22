package org.itbparnamirim.kadosh.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Matricula.class)
public abstract class Matricula_ {

	public static volatile SingularAttribute<Matricula, Membro> aluno;
	public static volatile ListAttribute<Matricula, Frequencia> frequencia;
	public static volatile SingularAttribute<Matricula, Integer> id;
	public static volatile SingularAttribute<Matricula, Turma> turma;
	public static volatile SingularAttribute<Matricula, BigDecimal> nota;

}

