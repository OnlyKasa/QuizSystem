package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.SubjectInformationSaveReq;
import com.ben.quiz.domain.dto.request.SubjectInformationSearchReq;
import com.ben.quiz.domain.dto.result.SubjectInformationDto;
import com.ben.quiz.domain.model.SubjectInformation;
import com.ben.quiz.domain.model.SubjectInformation_;
import com.ben.quiz.domain.repository.interfaces.SubjectInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("subjectRepository")
public class SubjectInformRepositoryImpl extends BaseRepositoryImpl implements SubjectInformRepository {
    @Override
    public List<SubjectInformationDto> search(SubjectInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<SubjectInformation> criteriaQuery = criteriaBuilder.createQuery(SubjectInformation.class);
        final Root<SubjectInformation> entityRoot = criteriaQuery.from(SubjectInformation.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<SubjectInformation> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<SubjectInformation> examinationRooms = query.getResultList();
        return examinationRooms.stream()
                .map(this::convertToSubjectInformDto)
                .collect(Collectors.toList());
    }
    private SubjectInformationDto convertToSubjectInformDto(SubjectInformation examinationRoom){
        return modelMapper.map(examinationRoom,SubjectInformationDto.class);
    }

    @Override
    public long count(SubjectInformationSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<SubjectInformation> entityRoot = criteriaQuery.from(SubjectInformation.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }


    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<SubjectInformation> entityRoot,
                                                             SubjectInformationSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(SubjectInformation_.iSubjectInformationPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(SubjectInformation_.strSubjectInformationName)),
                SQLUtil.AllLike(searchReq.getStrSubjectInformationName())));

        return predicates ;
    }


    @Override
    public SubjectInformationDto findByID(Integer iSubjectInformationPk) throws QuizException {
        return null;
    }

    @Override
    public SubjectInformation create(SubjectInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public SubjectInformation update(SubjectInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iSubjectInformationPk) throws QuizException {

    }
}
