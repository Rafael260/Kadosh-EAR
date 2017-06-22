package org.itbparnamirim.kadosh.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Membro.class)
public abstract class Membro_ {

	public static volatile SingularAttribute<Membro, String> telefone;
	public static volatile SingularAttribute<Membro, Boolean> administrador;
	public static volatile SingularAttribute<Membro, Grupo> grupo;
	public static volatile SingularAttribute<Membro, String> nome;
	public static volatile ListAttribute<Membro, Matricula> matriculas;
	public static volatile ListAttribute<Membro, Ministerio> ministerios;
	public static volatile SingularAttribute<Membro, String> senha;
	public static volatile SingularAttribute<Membro, Boolean> professor;
	public static volatile SingularAttribute<Membro, Boolean> tesoureiro;
	public static volatile ListAttribute<Membro, Turma> turmas;
	public static volatile SingularAttribute<Membro, Boolean> lider;
	public static volatile SingularAttribute<Membro, String> usuario;
	public static volatile SingularAttribute<Membro, Integer> id;
	public static volatile SingularAttribute<Membro, Date> dataNascimento;
	public static volatile SingularAttribute<Membro, Date> dataBatismoApresentacao;
	public static volatile SingularAttribute<Membro, String> email;

}

