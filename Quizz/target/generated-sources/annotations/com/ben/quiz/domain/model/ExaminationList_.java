package com.ben.quiz.domain.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExaminationList.class)
public abstract class ExaminationList_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<ExaminationList, Integer> iExaminationListPk;
	public static volatile SingularAttribute<ExaminationList, SubjectInformation> subjectInformationByISubjectInformationPk;
	public static volatile SingularAttribute<ExaminationList, Integer> iSubjectInformationPk;
	public static volatile SingularAttribute<ExaminationList, Integer> iTeacherInformationPk;
	public static volatile SingularAttribute<ExaminationList, Integer> iExaminationListPkEk;
	public static volatile SingularAttribute<ExaminationList, TeacherInformation> teacherInformationByITeacherInformationPk;
	public static volatile SingularAttribute<ExaminationList, Timestamp> dtExaminationDay;
	public static volatile SingularAttribute<ExaminationList, ExaminationRoom> examinationRoomByIExaminationRoomPk;
	public static volatile SingularAttribute<ExaminationList, Integer> iExaminationRoomPk;
	public static volatile CollectionAttribute<ExaminationList, ExaminationListDetail> examinationListDetailsByIExaminationListPk;

}

