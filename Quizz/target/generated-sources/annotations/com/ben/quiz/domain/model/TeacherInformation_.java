package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TeacherInformation.class)
public abstract class TeacherInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile CollectionAttribute<TeacherInformation, ExaminationInformation> examinationInformationsByITeacherInformationPk;
	public static volatile CollectionAttribute<TeacherInformation, Seiuser> seiusersByITeacherInformationPk;
	public static volatile SingularAttribute<TeacherInformation, Boolean> bTeacherInformationGender;
	public static volatile SingularAttribute<TeacherInformation, String> strTeacherInformationLastName;
	public static volatile SingularAttribute<TeacherInformation, Integer> iTeacherInformationPk;
	public static volatile SingularAttribute<TeacherInformation, Integer> iTeacherInformationPkEk;
	public static volatile CollectionAttribute<TeacherInformation, QuestionInformation> questionInformationsByITeacherInformationPk;
	public static volatile SingularAttribute<TeacherInformation, Integer> iFacultyInformationPk;
	public static volatile SingularAttribute<TeacherInformation, String> strTeacherInformationPhone;
	public static volatile SingularAttribute<TeacherInformation, String> strTeacherInformationFirstName;
	public static volatile SingularAttribute<TeacherInformation, FacultyInformation> facultyInformationByIFacultyInformationPk;

}

