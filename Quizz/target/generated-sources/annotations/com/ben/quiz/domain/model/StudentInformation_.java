package com.ben.quiz.domain.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentInformation.class)
public abstract class StudentInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile CollectionAttribute<StudentInformation, ExaminationListDetail> examinationListDetailsByIStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, String> strStudentInformationLastName;
	public static volatile SingularAttribute<StudentInformation, Integer> iStudentInformationCode;
	public static volatile SingularAttribute<StudentInformation, String> strStudentInformationFirstName;
	public static volatile SingularAttribute<StudentInformation, Date> dtStudentInformationBirthday;
	public static volatile CollectionAttribute<StudentInformation, ExaminationResult> examinationResultsByIStudentInformationPk;
	public static volatile SingularAttribute<StudentInformation, Integer> iStudentInformationPkEk;
	public static volatile SingularAttribute<StudentInformation, FacultyInformation> facultyInformationByIFacultyInformationPk;

}

