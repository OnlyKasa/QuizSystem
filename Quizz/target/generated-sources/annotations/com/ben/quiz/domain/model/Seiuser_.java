package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Seiuser.class)
public abstract class Seiuser_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<Seiuser, String> password;
	public static volatile SingularAttribute<Seiuser, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<Seiuser, Integer> iTeacherInformationPk;
	public static volatile SingularAttribute<Seiuser, StudentInformation> studentInformationByIStudentInformationPk;
	public static volatile SingularAttribute<Seiuser, TeacherInformation> teacherInformationByITeacherInformationPk;
	public static volatile SingularAttribute<Seiuser, String> userId;
	public static volatile SingularAttribute<Seiuser, String> topMenu;

}

