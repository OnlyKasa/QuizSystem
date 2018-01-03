package com.ben.quiz.domain.repository.impl;


import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.TestInformationDetail;
import com.ben.quiz.domain.model.TestInformationDetail_;
import com.ben.quiz.domain.repository.interfaces.TestInformationDetailRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository("testDetailRepository")
public class TestInformationDetailRepositoryImpl extends  BaseRepositoryImpl implements TestInformationDetailRepository {

    @Override
    public TestInformationDetail findByQuestionPkAndTestInformPk(Integer iQuestionInformationPk, Integer iTestInformationPk) throws QuizException {
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
            return query.getSingleResult();
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }
}
