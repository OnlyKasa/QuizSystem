package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationResultEntity.class)
public abstract class ExaminationResultEntity_ {

	public static volatile SingularAttribute<ExaminationResultEntity, Integer> iTestInformationPk;
	public static volatile SingularAttribute<ExaminationResultEntity, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<ExaminationResultEntity, Integer> iExaminationResultPk;
	public static volatile SingularAttribute<ExaminationResultEntity, Integer> iExaminationResultPkEk;
	public static volatile SingularAttribute<ExaminationResultEntity, Integer> iExaminationResultNumAnswerTrue;
	public static volatile SingularAttribute<ExaminationResultEntity, Double> fExaminationResultScore;

}

