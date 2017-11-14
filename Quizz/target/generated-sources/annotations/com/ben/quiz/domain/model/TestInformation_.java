package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TestInformation.class)
public abstract class TestInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<TestInformation, Integer> iTestInformationPk;
	public static volatile SingularAttribute<TestInformation, ExaminationInformation> examinationInformationByIExaminationInformationPk;
	public static volatile SingularAttribute<TestInformation, Integer> iTestInformationPkEk;
	public static volatile SingularAttribute<TestInformation, StudentInformation> studentInformationByIStudentInformationPk;
	public static volatile SingularAttribute<TestInformation, Integer> iExaminationResultNumAnswerTrue;
	public static volatile SingularAttribute<TestInformation, Double> fExaminationResultScore;

}

