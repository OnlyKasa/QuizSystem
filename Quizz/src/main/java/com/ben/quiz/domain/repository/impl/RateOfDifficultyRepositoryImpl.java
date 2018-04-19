package com.ben.quiz.domain.repository.impl;


import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RateOfDifficultyReq;
import com.ben.quiz.domain.dto.result.RateOfDifficultyDto;
import com.ben.quiz.domain.model.RateOfDifficulty;
import com.ben.quiz.domain.model.RateOfDifficulty_;
import com.ben.quiz.domain.repository.interfaces.RateOfDifficultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("difficultRepository")
public class RateOfDifficultyRepositoryImpl extends BaseRepositoryImpl implements RateOfDifficultyRepository{

    @Override
    public List<RateOfDifficultyDto> search(RateOfDifficultyReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<RateOfDifficulty> criteriaQuery = criteriaBuilder.createQuery(RateOfDifficulty.class);
        final Root<RateOfDifficulty> entityRoot = criteriaQuery.from(RateOfDifficulty.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<RateOfDifficulty> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<RateOfDifficulty> rateOfDifficulties = query.getResultList();
        return rateOfDifficulties.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public long count(RateOfDifficultyReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<RateOfDifficulty> entityRoot = criteriaQuery.from(RateOfDifficulty.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<RateOfDifficulty> entityRoot,
                                                             RateOfDifficultyReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(RateOfDifficulty_.iRateOfDifficultyPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(RateOfDifficulty_.strRateDifficultyName)),
                SQLUtil.AllLike(searchReq.getStrRateDifficultyName())));
        return predicates ;
    }

    private RateOfDifficultyDto convertToDto(RateOfDifficulty rateOfDifficulty){
        return  modelMapper.map(rateOfDifficulty,RateOfDifficultyDto.class);
    }


    @Override
    public RateOfDifficultyDto findByID(Integer iRateOfDifficultyPk) throws QuizException {
        RateOfDifficulty rateOfDifficulty = findOne(RateOfDifficulty.class,
                iRateOfDifficultyPk);
        if(rateOfDifficulty.getiRateOfDifficultyPkEk() == null){
            throw  new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
        return convertToDto(rateOfDifficulty);
    }

    @Override
    public RateOfDifficulty create(RateOfDifficultyReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public RateOfDifficulty update(RateOfDifficultyReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iRateOfDifficultyPk) throws QuizException {

    }
}
