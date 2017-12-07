package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSaveReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSearchReq;
import com.ben.quiz.domain.dto.result.TeacherInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.FacultyInformation_;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.domain.model.TeacherInformation_;
import com.ben.quiz.domain.repository.interfaces.TeacherInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("teacherRepository")
public class TeacherInformRepositoryImpl extends BaseRepositoryImpl implements TeacherInformRepository {

    @Override
    public List<TeacherInformDto> search(TeacherInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<TeacherInformation> entityRoot = criteriaQuery.from(TeacherInformation.class);
        final Join<TeacherInformation,FacultyInformation>
                faculty = entityRoot.join(TeacherInformation_.facultyInformationByIFacultyInformationPk
                                        , JoinType.LEFT);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                faculty,
                searchReq);

        criteriaQuery.multiselect(entityRoot,
                faculty)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<Tuple> examinationRooms = query.getResultList();
        return examinationRooms.stream()
                .map(this::convertToTeacherInformDto)
                .collect(Collectors.toList());
    }
    private TeacherInformDto convertToTeacherInformDto(Tuple tuple){
        TeacherInformDto teacherInformDto = new TeacherInformDto();
        modelMapper.map(tuple.get(0),teacherInformDto);
        modelMapper.map(tuple.get(1),teacherInformDto);
        return teacherInformDto ;
    }


    @Override
    public long count(TeacherInformationSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<TeacherInformation> entityRoot = criteriaQuery.from(TeacherInformation.class);
        final Join<TeacherInformation,FacultyInformation>
                faculty = entityRoot.join(TeacherInformation_.facultyInformationByIFacultyInformationPk
                , JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                faculty,
                searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<TeacherInformation> entityRoot,
                                                             Join<TeacherInformation,FacultyInformation> facultyInformationRoot,
                                                             TeacherInformationSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TeacherInformation_.iTeacherInformationPk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(TeacherInformation_.strTeacherInformationFirstName)),
                SQLUtil.AllLike(searchReq.getStrTeacherInformationFirstName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(TeacherInformation_.strTeacherInformationLastName)),
                SQLUtil.AllLike(searchReq.getStrTeacherInformationLastName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(facultyInformationRoot.get(FacultyInformation_.strFacultyInformationShortName)),
                SQLUtil.AllLike(searchReq.getStrFacultyInformationShortName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(facultyInformationRoot.get(FacultyInformation_.strFacultyInformationFullName)),
                SQLUtil.AllLike(searchReq.getStrFacultyInformationFullName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(TeacherInformation_.strTeacherInformationPhone)),
                SQLUtil.AllLike(searchReq.getStrTeacherInformationPhone())));
        return predicates ;
    }
    @Override
    public TeacherInformDto findByID(Integer iTeacherInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<TeacherInformation> entityRoot = criteriaQuery.from(TeacherInformation.class);
        final Join<TeacherInformation,FacultyInformation>
                faculty = entityRoot.join(TeacherInformation_.facultyInformationByIFacultyInformationPk
                , JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TeacherInformation_.iTeacherInformationPk),
                iTeacherInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TeacherInformation_.iTeacherInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                                  faculty)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        Tuple tuple ;
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        try {
            tuple = query.getSingleResult();
            return convertToTeacherInformDto(tuple);
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }


    @Override
    public TeacherInformation create(TeacherInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public TeacherInformation update(TeacherInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iTeacherInformationPk) throws QuizException {

    }
}
