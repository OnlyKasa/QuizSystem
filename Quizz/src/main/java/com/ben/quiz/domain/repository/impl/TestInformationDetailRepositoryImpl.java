package com.ben.quiz.domain.repository.impl;


import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.model.QuestionInformation;
import com.ben.quiz.domain.model.TestInformation;
import com.ben.quiz.domain.model.TestInformationDetail;
import com.ben.quiz.domain.model.TestInformationDetail_;
import com.ben.quiz.domain.repository.interfaces.TestInformationDetailRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository("testDetailRepository")
public class TestInformationDetailRepositoryImpl extends  BaseRepositoryImpl implements TestInformationDetailRepository {

    @Override
    public TestInformationDetailDto findByQuestionPkAndTestInformPk(Integer iQuestionInformationPk, Integer iTestInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<TestInformationDetail> criteriaQuery = criteriaBuilder.createQuery(TestInformationDetail.class);
        final Root<TestInformationDetail> entityRoot = criteriaQuery.from(TestInformationDetail.class);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformationDetail_.iQuestionInformationPk),
                iQuestionInformationPk));
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformationDetail_.iTestInformationPk),
                iTestInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformationDetail_.iTestDetailInformationPkEk)));

        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<TestInformationDetail> query = entityManager.createQuery(criteriaQuery);
        try {
            return convertToDto(query.getSingleResult());
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }

    @Override
    public List<TestInformationDetailDto> findByTestInformationPk(Integer iTestInformationPk, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<TestInformationDetail> entityRoot = criteriaQuery.from(TestInformationDetail.class);

        final Join<TestInformationDetail,QuestionInformation>
                question = entityRoot.join(TestInformationDetail_.questionInformationByIQuestionInformationPk
                , JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>() ;

        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformationDetail_.iTestInformationPk),
                iTestInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformationDetail_.iTestDetailInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,question)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);

        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<Tuple> tuples = query.getResultList();
        List<TestInformationDetailDto>testInformationDetailDtos = new ArrayList<>();
        for (Tuple tuple:tuples
             ) {
            testInformationDetailDtos.add(convertToDetailDto(tuple));
        }
        return testInformationDetailDtos;
    }

    private TestInformationDetailDto convertToDetailDto(Tuple tuple){
        TestInformationDetailDto testInformationDetailDto = new TestInformationDetailDto();
        modelMapper.map(tuple.get(0),testInformationDetailDto);
        modelMapper.map(tuple.get(1),testInformationDetailDto);
        return testInformationDetailDto;
    }
    @Override
    public long countByTestID(Integer iTestInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<TestInformationDetail> entityRoot = criteriaQuery.from(TestInformationDetail.class);
        List<Predicate> predicates = new ArrayList<>() ;

        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformationDetail_.iTestInformationPk),
                iTestInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformationDetail_.iTestDetailInformationPkEk)));

        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }


    private TestInformationDetailDto convertToDto(TestInformationDetail testInformationDetail){
        return modelMapper.map(testInformationDetail, TestInformationDetailDto.class);
    }
}
