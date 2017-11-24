package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacultyInformation.class)
public abstract class FacultyInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<FacultyInformation, String> strFacultyInformationFullName;
	public static volatile SingularAttribute<FacultyInformation, Integer> iFacultyInformationPkEk;
	public static volatile CollectionAttribute<FacultyInformation, StudentInformation> studentInformationsByIFacultyInformationPk;
	public static volatile SingularAttribute<FacultyInformation, Integer> iFacultyInformationPk;
	public static volatile SingularAttribute<FacultyInformation, String> strFacultyInformationShortName;
	public static volatile CollectionAttribute<FacultyInformation, TeacherInformation> teacherInformationsByIFacultyInformationPk;

}

