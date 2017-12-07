package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.FacultyInformSearchReq;
import com.ben.quiz.domain.dto.request.FacultyInformationSaveReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.FacultyInformation_;
import com.ben.quiz.domain.repository.interfaces.FacultyInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("facultyRepository")
public class FacultyInformRepositoryImpl extends BaseRepositoryImpl
        implements FacultyInformRepository {


    @Override
    public List<FacultyInformDto> search(FacultyInformSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<FacultyInformation> criteriaQuery = criteriaBuilder.createQuery(FacultyInformation.class);
        final Root<FacultyInformation> entityRoot = criteriaQuery.from(FacultyInformation.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<FacultyInformation> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<FacultyInformation> facultyInformations = query.getResultList();
        return facultyInformations.stream()
                .map(this::convertToFacultyInformDto)
                .collect(Collectors.toList());
    }

    private FacultyInformDto convertToFacultyInformDto(FacultyInformation facultyInformation){
        return modelMapper.map(facultyInformation,FacultyInformDto.class);
    }

    @Override
    public long count(FacultyInformSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<FacultyInformation> entityRoot = criteriaQuery.from(FacultyInformation.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                    .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<FacultyInformation> entityRoot,
                                                             FacultyInformSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(FacultyInformation_.iFacultyInformationPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(FacultyInformation_.strFacultyInformationFullName)),
                SQLUtil.AllLike(searchReq.getStrFacultyInformationFullName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(FacultyInformation_.strFacultyInformationShortName)),
                SQLUtil.AllLike(searchReq.getStrFacultyInformationShortName())));
        return predicates ;
    }

    @Override
    public FacultyInformation findByID(Integer iFacultyInformationPk) throws QuizException {
        FacultyInformation facultyInformation = findOne(FacultyInformation.class,
                iFacultyInformationPk);
        if(facultyInformation.getiFacultyInformationPkEk() == null){
            throw  new QuizException(CodeConst.ErrorCode.Err_Deleted_record, CodeConst.ErrorMess.Err_Deleted_record);
        }
        return facultyInformation;
    }

    @Override
    public FacultyInformation create(FacultyInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public FacultyInformation update(FacultyInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iFacultyInformationPk) throws QuizException {

    }
}
