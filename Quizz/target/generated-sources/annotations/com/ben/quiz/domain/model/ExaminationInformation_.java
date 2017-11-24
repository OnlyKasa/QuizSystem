package com.ben.quiz.domain.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationInformation.class)
public abstract class ExaminationInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<ExaminationInformation, SubjectInformation> subjectInformationByISubjectInformationPk;
	public static volatile CollectionAttribute<ExaminationInformation, ExaminationInformationDetail> examinationInformationDetailsByIExaminationInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, String> strExaminationInformationCode;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iTeacherInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iTestInformationTime;
	public static volatile SingularAttribute<ExaminationInformation, TeacherInformation> teacherInformationByITeacherInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, Timestamp> dtExaminationDay;
	public static volatile SingularAttribute<ExaminationInformation, ExaminationRoom> examinationRoomByIExaminationRoomPk;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iExaminationInformationPkEk;
	public static volatile CollectionAttribute<ExaminationInformation, TestInformation> testInformationsByIExaminationInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iExaminationRoomPk;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iExaminationInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iSubjectInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, RateOfDifficulty> rateOfDifficultyByIRateOfDifficultyPk;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iRateOfDifficultyPk;

}

