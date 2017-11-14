package com.ben.quiz.domain.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationInformation.class)
public abstract class ExaminationInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<ExaminationInformation, Integer> iExaminationInformationPk;
	public static volatile SingularAttribute<ExaminationInformation, String> strExaminationInformationCode;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iTestInformationTime;
	public static volatile SingularAttribute<ExaminationInformation, Timestamp> dtExaminationDay;
	public static volatile SingularAttribute<ExaminationInformation, Integer> iExaminationInformationPkEk;

}

