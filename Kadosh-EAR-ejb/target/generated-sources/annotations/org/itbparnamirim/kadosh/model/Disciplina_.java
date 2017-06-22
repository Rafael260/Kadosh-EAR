package org.itbparnamirim.kadosh.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Disciplina.class)
public abstract class Disciplina_ {

	public static volatile SingularAttribute<Disciplina, String> sigla;
	public static volatile SingularAttribute<Disciplina, String> ciclo;
	public static volatile ListAttribute<Disciplina, Turma> turmas;
	public static volatile SingularAttribute<Disciplina, String> nome;
	public static volatile SingularAttribute<Disciplina, Integer> id;

}

