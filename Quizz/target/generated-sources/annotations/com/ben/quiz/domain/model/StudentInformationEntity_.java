package com.ben.quiz.domain.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentInformationEntity.class)
public abstract class StudentInformationEntity_ {

	public static volatile SingularAttribute<StudentInformationEntity, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<StudentInformationEntity, String> strStudentInformationLastName;
	public static volatile SingularAttribute<StudentInformationEntity, String> strStudentInformationFirstName;
	public static volatile SingularAttribute<StudentInformationEntity, Integer> iStudentInformationCode;
	public static volatile SingularAttribute<StudentInformationEntity, Integer> iFacultyInformationPk;
	public static volatile SingularAttribute<StudentInformationEntity, Date> dtStudentInformationBirthday;
	public static volatile SingularAttribute<StudentInformationEntity, Integer> iStudentInformationPkEk;

}

