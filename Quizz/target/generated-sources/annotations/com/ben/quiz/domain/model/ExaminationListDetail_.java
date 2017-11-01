package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationListDetail.class)
public abstract class ExaminationListDetail_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<ExaminationListDetail, Integer> iExaminationListPk;
	public static volatile SingularAttribute<ExaminationListDetail, Integer> iStudentInformationPk;
	public static volatile SingularAttribute<ExaminationListDetail, Integer> iExaminationListDetailPk;
	public static volatile SingularAttribute<ExaminationListDetail, Integer> iExaminationListDetailPkEk;
	public static volatile SingularAttribute<ExaminationListDetail, StudentInformation> studentInformationByIStudentInformationPk;
	public static volatile SingularAttribute<ExaminationListDetail, ExaminationList> examinationListByIExaminationListPk;

}

