package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationResult.class)
public abstract class ExaminationResult_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<ExaminationResult, Integer> iTestInformationPk;
	public static volatile SingularAttribute<ExaminationResult, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<ExaminationResult, StudentInformation> studentInformationByIStudentInformationPk;
	public static volatile SingularAttribute<ExaminationResult, Integer> iExaminationResultPk;
	public static volatile SingularAttribute<ExaminationResult, Integer> iExaminationResultPkEk;
	public static volatile SingularAttribute<ExaminationResult, Integer> iExaminationResultNumAnswerTrue;
	public static volatile SingularAttribute<ExaminationResult, Double> fExaminationResultScore;
	public static volatile SingularAttribute<ExaminationResult, TestInformation> testInformationByITestInformationPk;

}

