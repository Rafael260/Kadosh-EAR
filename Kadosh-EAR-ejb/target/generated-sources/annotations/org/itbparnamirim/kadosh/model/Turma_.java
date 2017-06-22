package org.itbparnamirim.kadosh.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turma.class)
public abstract class Turma_ {

	public static volatile SingularAttribute<Turma, String> anoLetivo;
	public static volatile SingularAttribute<Turma, Disciplina> disciplina;
	public static volatile SingularAttribute<Turma, Integer> id;
	public static volatile ListAttribute<Turma, Matricula> matriculas;
	public static volatile ListAttribute<Turma, Membro> professores;

}

