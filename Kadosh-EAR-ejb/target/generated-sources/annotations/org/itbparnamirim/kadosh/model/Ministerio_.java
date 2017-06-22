package org.itbparnamirim.kadosh.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ministerio.class)
public abstract class Ministerio_ {

	public static volatile ListAttribute<Ministerio, Membro> membrosMinisterio;
	public static volatile SingularAttribute<Ministerio, Membro> lider;
	public static volatile SingularAttribute<Ministerio, String> nome;
	public static volatile SingularAttribute<Ministerio, Integer> id;
	public static volatile SingularAttribute<Ministerio, String> descricao;

}

