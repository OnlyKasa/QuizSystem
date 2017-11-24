package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RateOfDifficulty.class)
public abstract class RateOfDifficulty_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<RateOfDifficulty, Integer> iRateOfDifficultyPk;
	public static volatile CollectionAttribute<RateOfDifficulty, ExaminationInformation> examinationInformationsByIRateOfDifficultyPk;
	public static volatile SingularAttribute<RateOfDifficulty, Integer> iNumQuestionLevel3;
	public static volatile SingularAttribute<RateOfDifficulty, Integer> iNumQuestionLevel4;
	public static volatile SingularAttribute<RateOfDifficulty, Integer> iRateOfDifficultyPkEk;
	public static volatile SingularAttribute<RateOfDifficulty, Integer> iNumQuestionLevel1;
	public static volatile SingularAttribute<RateOfDifficulty, Integer> iNumQuestionLevel2;

}

