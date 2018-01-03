package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TestInformationSearchReq;
import com.ben.quiz.domain.dto.result.TestInformationDto;
import com.ben.quiz.domain.model.*;
import com.ben.quiz.domain.repository.interfaces.TestInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("testRepository")
public class TestInformRepositoryImpl extends BaseRepositoryImpl implements TestInformRepository{

    @Override
    public List<TestInformationDto> search(TestInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<TestInformation> entityRoot = criteriaQuery.from(TestInformation.class);
        final Join<TestInformation,StudentInformation>
                teacher = entityRoot.join(TestInformation_.studentInformationByIStudentInformationPk,
                JoinType.LEFT);
        final Join<TestInformation,ExaminationInformation>
                examination = entityRoot.join(TestInformation_.examinationInformationByIExaminationInformationPk,
                JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                teacher,
                examination,
                searchReq);

        criteriaQuery.multiselect(entityRoot,
                teacher,examination)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<Tuple> examinationRooms = query.getResultList();
        return examinationRooms.stream()
                .map(this::convertToTestInformDto)
                .collect(Collectors.toList());
    }
    private TestInformationDto convertToTestInformDto(Tuple tuple){
        TestInformationDto questionInformDto = new TestInformationDto();
        modelMapper.map(tuple.get(0),questionInformDto);
        modelMapper.map(tuple.get(1),questionInformDto);
        modelMapper.map(tuple.get(2),questionInformDto);
        return questionInformDto ;
    }
    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<TestInformation> entityRoot,
                                                             Join<TestInformation,StudentInformation> student,
                                                             Join<TestInformation,ExaminationInformation> examination,
                                                             TestInformationSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(student.get(StudentInformation_.iStudentInformationCode)),
                SQLUtil.AllLike(searchReq.getiStudentInformationCode())));

        predicates.add(criteriaBuilder.equal(examination.get(ExaminationInformation_.strExaminationInformationCode),
                searchReq.getStrExaminationInformationCode()));

        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(student.get(StudentInformation_.strStudentInformationFirstName)),
                SQLUtil.AllLike(searchReq.getStrStudentInformationFirstName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(student.get(StudentInformation_.strStudentInformationLastName)),
                SQLUtil.AllLike(searchReq.getStrStudentInformationLastName())));

        return predicates ;
    }
    @Override
    public long count(TestInformationSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<TestInformation> entityRoot = criteriaQuery.from(TestInformation.class);
        final Join<TestInformation,StudentInformation>
                teacher = entityRoot.join(TestInformation_.studentInformationByIStudentInformationPk,
                JoinType.LEFT);
        final Join<TestInformation,ExaminationInformation>
                examination = entityRoot.join(TestInformation_.examinationInformationByIExaminationInformationPk,
                JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                teacher,
                examination,
                searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public TestInformationDto findByID(Integer iTestInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<TestInformation> entityRoot = criteriaQuery.from(TestInformation.class);
        final Join<TestInformation,StudentInformation>
                teacher = entityRoot.join(TestInformation_.studentInformationByIStudentInformationPk,
                JoinType.LEFT);
        final Join<TestInformation,ExaminationInformation>
                examination = entityRoot.join(TestInformation_.examinationInformationByIExaminationInformationPk,
                JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformation_.iTestInformationPk),
                iTestInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                teacher,examination)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        Tuple tuple ;
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        try {
            tuple = query.getSingleResult();
            return convertToTestInformDto(tuple);
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }
}
