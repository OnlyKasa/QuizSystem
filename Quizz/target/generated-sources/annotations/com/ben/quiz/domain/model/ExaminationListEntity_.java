package com.ben.quiz.domain.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationListEntity.class)
public abstract class ExaminationListEntity_ {

	public static volatile SingularAttribute<ExaminationListEntity, Integer> iExaminationListPk;
	public static volatile SingularAttribute<ExaminationListEntity, Integer> iSubjectInformationPk;
	public static volatile SingularAttribute<ExaminationListEntity, Integer> iTeacherInformationPk;
	public static volatile SingularAttribute<ExaminationListEntity, Integer> iExaminationListPkEk;
	public static volatile SingularAttribute<ExaminationListEntity, Timestamp> dtExaminationDay;
	public static volatile SingularAttribute<ExaminationListEntity, Integer> iExaminationRoomPk;

}

