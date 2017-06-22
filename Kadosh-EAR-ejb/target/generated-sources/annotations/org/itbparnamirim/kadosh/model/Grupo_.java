package org.itbparnamirim.kadosh.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Grupo.class)
public abstract class Grupo_ {

	public static volatile SingularAttribute<Grupo, String> tipo;
	public static volatile SingularAttribute<Grupo, String> diaSemana;
	public static volatile SingularAttribute<Grupo, Date> hora;
	public static volatile SingularAttribute<Grupo, Membro> lider;
	public static volatile ListAttribute<Grupo, Membro> membrosGrupo;
	public static volatile SingularAttribute<Grupo, Integer> id;
	public static volatile SingularAttribute<Grupo, String> localReuniao;

}

