package com.ben.quiz.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuestionInformation.class)
public abstract class QuestionInformation_ extends com.ben.quiz.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<QuestionInformation, SubjectInformation> subjectInformationByISubjectInformationPk;
	public static volatile SingularAttribute<QuestionInformation, String> strQuestionContentInformation;
	public static volatile SingularAttribute<QuestionInformation, Integer> iQuestionInformationPkEk;
	public static volatile SingularAttribute<QuestionInformation, TeacherInformation> teacherInformationByITeacherInformationPk;
	public static volatile SingularAttribute<QuestionInformation, String> strAnswerTrue;
	public static volatile CollectionAttribute<QuestionInformation, TestDetailInformation> testDetailInformationsByIQuestionInformationPk;
	public static volatile SingularAttribute<QuestionInformation, Integer> iQuestionLevelInformation;
	public static volatile SingularAttribute<QuestionInformation, Integer> iQuestionInformationPk;
	public static volatile SingularAttribute<QuestionInformation, String> strAnswer3;
	public static volatile SingularAttribute<QuestionInformation, String> strAnswer4;
	public static volatile SingularAttribute<QuestionInformation, String> strAnswer5;
	public static volatile SingularAttribute<QuestionInformation, String> strAnswer1;
	public static volatile SingularAttribute<QuestionInformation, String> strAnswer2;

}

