package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TestDetailInformation.class)
public abstract class TestDetailInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<TestDetailInformation, Integer> iTestInformationPk;
	public static volatile SingularAttribute<TestDetailInformation, QuestionInformation> questionInformationByIQuestionInformationPk;
	public static volatile SingularAttribute<TestDetailInformation, Integer> iQuestionInformationPk;
	public static volatile SingularAttribute<TestDetailInformation, Integer> iTestDetailInformationPk;
	public static volatile SingularAttribute<TestDetailInformation, Integer> iTestDetailInformationPkEk;
	public static volatile SingularAttribute<TestDetailInformation, TestInformation> testInformationByITestInformationPk;

}

