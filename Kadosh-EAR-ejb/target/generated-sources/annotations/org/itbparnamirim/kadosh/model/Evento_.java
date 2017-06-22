package org.itbparnamirim.kadosh.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evento.class)
public abstract class Evento_ {

	public static volatile SingularAttribute<Evento, Date> diaHora;
	public static volatile SingularAttribute<Evento, String> nome;
	public static volatile SingularAttribute<Evento, String> localEvento;
	public static volatile SingularAttribute<Evento, Integer> id;

}

