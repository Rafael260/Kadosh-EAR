package org.itbparnamirim.kadosh.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Meditacao.class)
public abstract class Meditacao_ {

	public static volatile SingularAttribute<Meditacao, String> diaSemana;
	public static volatile SingularAttribute<Meditacao, String> ilustracao;
	public static volatile SingularAttribute<Meditacao, String> titulo;
	public static volatile SingularAttribute<Meditacao, String> versiculoBase;
	public static volatile ListAttribute<Meditacao, String> decisoes;
	public static volatile SingularAttribute<Meditacao, String> aprofundando;
	public static volatile SingularAttribute<Meditacao, Integer> id;
	public static volatile ListAttribute<Meditacao, String> versiculosDeApoio;

}

