package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SeiUser.class)
public abstract class SeiUser_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<SeiUser, String> password;
	public static volatile SingularAttribute<SeiUser, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<SeiUser, Integer> iTeacherInformationPk;
	public static volatile SingularAttribute<SeiUser, StudentInformation> studentInformationByIStudentInformationPk;
	public static volatile SingularAttribute<SeiUser, TeacherInformation> teacherInformationByITeacherInformationPk;
	public static volatile SingularAttribute<SeiUser, String> userId;
	public static volatile SingularAttribute<SeiUser, String> topMenu;

}

