package org.itbparnamirim.kadosh.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Noticia.class)
public abstract class Noticia_ {

	public static volatile SingularAttribute<Noticia, String> manchete;
	public static volatile SingularAttribute<Noticia, String> textoDaNoticia;
	public static volatile SingularAttribute<Noticia, Integer> id;
	public static volatile SingularAttribute<Noticia, Date> validade;
	public static volatile SingularAttribute<Noticia, String> destinatario;

}

