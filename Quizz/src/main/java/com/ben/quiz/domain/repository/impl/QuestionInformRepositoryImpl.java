package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.QuestionInformSaveReq;
import com.ben.quiz.domain.dto.request.QuestionInformSearchReq;
import com.ben.quiz.domain.dto.result.QuestionInformDto;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.*;
import com.ben.quiz.domain.repository.interfaces.QuestionInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("questionRepository")
public class QuestionInformRepositoryImpl extends BaseRepositoryImpl implements QuestionInformRepository {

    @Override
    public List<QuestionInformDto> search(QuestionInformSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<QuestionInformation> entityRoot = criteriaQuery.from(QuestionInformation.class);
        final Join<QuestionInformation,TeacherInformation>
                teacher = entityRoot.join(QuestionInformation_.teacherInformationByITeacherInformationPk,
                JoinType.LEFT);
        final Join<QuestionInformation,SubjectInformation>
                subject = entityRoot.join(QuestionInformation_.subjectInformationByISubjectInformationPk,
                JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                teacher,
                subject,
                searchReq);

        criteriaQuery.multiselect(entityRoot,
                teacher,subject)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<Tuple> examinationRooms = query.getResultList();
        return examinationRooms.stream()
                .map(this::convertToQuestionInformDto)
                .collect(Collectors.toList());
    }

    private QuestionInformDto convertToQuestionInformDto(Tuple tuple){
        QuestionInformDto questionInformDto = new QuestionInformDto();
        modelMapper.map(tuple.get(0),questionInformDto);
        modelMapper.map(tuple.get(1),questionInformDto);
        modelMapper.map(tuple.get(2),questionInformDto);
        return questionInformDto ;
    }
    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<QuestionInformation> entityRoot,
                                                             Join<QuestionInformation,TeacherInformation> teacher,
                                                             Join<QuestionInformation,SubjectInformation> subject,
                                                             QuestionInformSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(QuestionInformation_.iQuestionInformationPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(QuestionInformation_.strQuestionContentInformation)),
                SQLUtil.AllLike(searchReq.getStrQuestionContentInformation())));
        predicates.add(criteriaBuilder.equal(entityRoot.get(QuestionInformation_.iQuestionInformationLevel),
                searchReq.getiQuestionInformationPk()));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(subject.get(SubjectInformation_.strSubjectInformationName)),
                SQLUtil.AllLike(searchReq.getStrSubjectInformationName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(teacher.get(TeacherInformation_.strTeacherInformationLastName)),
                SQLUtil.AllLike(searchReq.getStrTeacherInformationLastName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(teacher.get(TeacherInformation_.strTeacherInformationFirstName)),
                SQLUtil.AllLike(searchReq.getStrTeacherInformationFirstName())));
        return predicates ;
    }
    @Override
    public long count(QuestionInformSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<QuestionInformation> entityRoot = criteriaQuery.from(QuestionInformation.class);
        final Join<QuestionInformation,TeacherInformation>
                teacher = entityRoot.join(QuestionInformation_.teacherInformationByITeacherInformationPk,
                JoinType.LEFT);
        final Join<QuestionInformation,SubjectInformation>
                subject = entityRoot.join(QuestionInformation_.subjectInformationByISubjectInformationPk,
                JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                teacher,
                subject,
                searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public QuestionInformDto findByID(Integer iQuestionInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<QuestionInformation> entityRoot = criteriaQuery.from(QuestionInformation.class);
        final Join<QuestionInformation,TeacherInformation>
                teacher = entityRoot.join(QuestionInformation_.teacherInformationByITeacherInformationPk,
                JoinType.LEFT);
        final Join<QuestionInformation,SubjectInformation>
                subject = entityRoot.join(QuestionInformation_.subjectInformationByISubjectInformationPk,
                JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(QuestionInformation_.iQuestionInformationPk),
                iQuestionInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(QuestionInformation_.iQuestionInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                teacher,subject)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        Tuple tuple ;
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        try {
            tuple = query.getSingleResult();
            return convertToQuestionInformDto(tuple);
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }

    @Override
    public List<QuestionInformDto> findBySubjectID(Integer iSubjectInformationPk, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<QuestionInformation> entityRoot = criteriaQuery.from(QuestionInformation.class);
        final Join<QuestionInformation,TeacherInformation>
                teacher = entityRoot.join(QuestionInformation_.teacherInformationByITeacherInformationPk,
                JoinType.LEFT);
        final Join<QuestionInformation,SubjectInformation>
                subject = entityRoot.join(QuestionInformation_.subjectInformationByISubjectInformationPk,
                JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(QuestionInformation_.iSubjectInformationPk),
                iSubjectInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(QuestionInformation_.iQuestionInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                teacher,subject)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        List<Tuple> examinationRooms = query.getResultList();
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        return examinationRooms.stream()
                .map(this::convertToQuestionInformDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long countBySubjectID(Integer iSubjectInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<QuestionInformation> entityRoot = criteriaQuery.from(QuestionInformation.class);
        final Join<QuestionInformation,TeacherInformation>
                teacher = entityRoot.join(QuestionInformation_.teacherInformationByITeacherInformationPk,
                JoinType.LEFT);
        final Join<QuestionInformation,SubjectInformation>
                subject = entityRoot.join(QuestionInformation_.subjectInformationByISubjectInformationPk,
                JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>() ;

        predicates.add(criteriaBuilder.equal(entityRoot.get(QuestionInformation_.iSubjectInformationPk),
                iSubjectInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(QuestionInformation_.iQuestionInformationPkEk)));

        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public QuestionInformation create(QuestionInformSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public QuestionInformation update(QuestionInformSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iQuestionInformationPk) throws QuizException {

    }
}
