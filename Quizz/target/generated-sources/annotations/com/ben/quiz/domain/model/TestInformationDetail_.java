package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TestInformationDetail.class)
public abstract class TestInformationDetail_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<TestInformationDetail, String> strStudentAnswer;
	public static volatile SingularAttribute<TestInformationDetail, Integer> iTestInformationDetailPk;
	public static volatile SingularAttribute<TestInformationDetail, QuestionInformation> questionInformationByIQuestionInformationPk;
	public static volatile SingularAttribute<TestInformationDetail, Integer> iTestDetailInformationPkEk;
	public static volatile SingularAttribute<TestInformationDetail, TestInformation> testInformationByITestInformationPk;

}

