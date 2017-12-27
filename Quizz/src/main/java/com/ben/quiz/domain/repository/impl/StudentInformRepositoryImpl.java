package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.StudentInformationSaveReq;
import com.ben.quiz.domain.dto.request.StudentInformationSearchReq;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.FacultyInformation_;
import com.ben.quiz.domain.model.StudentInformation;
import com.ben.quiz.domain.model.StudentInformation_;
import com.ben.quiz.domain.repository.interfaces.StudentInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("studentRepository")
public class StudentInformRepositoryImpl extends BaseRepositoryImpl implements StudentInformRepository {
    @Override
    public List<StudentInformDto> search(StudentInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<StudentInformation> entityRoot = criteriaQuery.from(StudentInformation.class);
        final Join<StudentInformation,FacultyInformation>
                faculty = entityRoot.join(StudentInformation_.facultyInformationByIFacultyInformationPk
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
                .map(this::convertToStudentInformDto)
                .collect(Collectors.toList());
    }


    private StudentInformDto convertToStudentInformDto(Tuple tuple){
        StudentInformDto studentInformDto = new StudentInformDto();
        modelMapper.map(tuple.get(0),studentInformDto);
        modelMapper.map(tuple.get(1),studentInformDto);
        return studentInformDto ;
    }


    @Override
    public long count(StudentInformationSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<StudentInformation> entityRoot = criteriaQuery.from(StudentInformation.class);
        final Join<StudentInformation,FacultyInformation>
                faculty = entityRoot.join(StudentInformation_.facultyInformationByIFacultyInformationPk
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
                                                             Root<StudentInformation> entityRoot,
                                                             Join<StudentInformation,FacultyInformation> facultyInformationRoot,
                                                             StudentInformationSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(StudentInformation_.iStudentInformationPkEk)));
        predicates.add(criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(entityRoot.get(StudentInformation_.strStudentInformationFirstName)),
                SQLUtil.AllLike(searchReq.getStrStudentInformationFirstName())),

                criteriaBuilder.like(criteriaBuilder.lower(entityRoot.get(StudentInformation_.strStudentInformationLastName)),
                SQLUtil.AllLike(searchReq.getStrStudentInformationLastName()))));

        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(facultyInformationRoot.get(FacultyInformation_.strFacultyInformationShortName)),
                SQLUtil.AllLike(searchReq.getStrFacultyInformationShortName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(facultyInformationRoot.get(FacultyInformation_.strFacultyInformationFullName)),
                SQLUtil.AllLike(searchReq.getStrFacultyInformationFullName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(StudentInformation_.iStudentInformationCode)),
                SQLUtil.AllLike(searchReq.getiStudentInformationCode())));
        predicates.add(criteriaBuilder.equal(
                entityRoot.get(StudentInformation_.dtStudentInformationBirthday),
                searchReq.getDtStudentInformationBirthday()));

        return predicates ;
    }
    @Override
    public StudentInformDto findByID(Integer iStudentInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<StudentInformation> entityRoot = criteriaQuery.from(StudentInformation.class);
        final Join<StudentInformation,FacultyInformation>
                faculty = entityRoot.join(StudentInformation_.facultyInformationByIFacultyInformationPk
                , JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(StudentInformation_.iStudentInformationPk),
                iStudentInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(StudentInformation_.iStudentInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                faculty)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        Tuple tuple ;
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        try {
            tuple = query.getSingleResult();
            return convertToStudentInformDto(tuple);
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }

    @Override
    public StudentInformation create(StudentInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public StudentInformation update(StudentInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iStudentInformationPk) throws QuizException {

    }
}
