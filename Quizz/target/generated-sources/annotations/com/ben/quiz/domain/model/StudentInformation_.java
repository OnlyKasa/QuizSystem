package com.ben.quiz.domain.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentInformation.class)
public abstract class StudentInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile CollectionAttribute<StudentInformation, Seiuser> seiusersByIStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, String> strStudentInformationLastName;
	public static volatile CollectionAttribute<StudentInformation, TestInformation> testInformationsByIStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, String> iStudentInformationCode;
	public static volatile SingularAttribute<StudentInformation, String> strStudentInformationFirstName;
	public static volatile CollectionAttribute<StudentInformation, ExaminationInformationDetail> examinationInformationDetailsByIStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, Integer> iFacultyInformationPk;
	public static volatile SingularAttribute<StudentInformation, Date> dtStudentInformationBirthday;
	public static volatile SingularAttribute<StudentInformation, Integer> iStudentInformationPkEk;
	public static volatile SingularAttribute<StudentInformation, FacultyInformation> facultyInformationByIFacultyInformationPk;

}

