package com.ben.quiz.domain.repository.impl;


import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.ExaminationInformationSaveReq;
import com.ben.quiz.domain.dto.request.ExaminationInformationSearchReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.ExaminationInformationDto;
import com.ben.quiz.domain.model.*;
import com.ben.quiz.domain.repository.interfaces.ExaminationInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("examinationRepository")
public class ExaminationInformRepositoryImpl extends BaseRepositoryImpl
        implements ExaminationInformRepository{


    @Override
    public List<ExaminationInformationDto> search(ExaminationInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<ExaminationInformation> entityRoot = criteriaQuery.from(ExaminationInformation.class);
        final Join<ExaminationInformation,RateOfDifficulty>
                difficulty = entityRoot.join(ExaminationInformation_.rateOfDifficultyByIRateOfDifficultyPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,TeacherInformation>
                teacher= entityRoot.join(ExaminationInformation_.teacherInformationByITeacherInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,SubjectInformation>
                subject= entityRoot.join(ExaminationInformation_.subjectInformationByISubjectInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,ExaminationRoom>
                room= entityRoot.join(ExaminationInformation_.examinationRoomByIExaminationRoomPk
                , JoinType.LEFT);


        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                difficulty,
                teacher,
                subject,
                room,
                searchReq);

        criteriaQuery.multiselect(entityRoot,
                difficulty,teacher,subject,room)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<Tuple> examinationRooms = query.getResultList();
        return examinationRooms.stream()
                .map(this::convertToExaminationInformDto)
                .collect(Collectors.toList());
    }

    private ExaminationInformationDto convertToExaminationInformDto(Tuple tuple){
        ExaminationInformationDto examinationInformationDto = new ExaminationInformationDto();
        for(int i= 0 ;i< tuple.toArray().length;i++){
            if(tuple.get(i) !=null){
                modelMapper.map(tuple.get(i),examinationInformationDto);
            }
        }
        return examinationInformationDto;
    }

    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<ExaminationInformation> entityRoot,
                                                             Join<ExaminationInformation,RateOfDifficulty> difficulty,
                                                             Join<ExaminationInformation,TeacherInformation> teacher,
                                                             Join<ExaminationInformation,SubjectInformation> subject,
                                                             Join<ExaminationInformation,ExaminationRoom> room,
                                                             ExaminationInformationSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(ExaminationInformation_.iExaminationInformationPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(ExaminationInformation_.strExaminationInformationCode)),
                SQLUtil.AllLike(searchReq.getStrExaminationInformationCode())));

        if(searchReq.getStrExaminationRoomName() != null && !searchReq.getStrExaminationRoomName().equals("")) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(room.get(ExaminationRoom_.strExaminationRoomName)),
                    SQLUtil.AllLike(searchReq.getStrExaminationRoomName())));
        }
        if(searchReq.getStrRateDifficultyName()!= null && !searchReq.getStrRateDifficultyName().equals("")) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(difficulty.get(RateOfDifficulty_.strRateDifficultyName)),
                    SQLUtil.AllLike(searchReq.getStrRateDifficultyName())));
        }
        if(searchReq.getStrTeacherInformationFirstName()!= null &&!searchReq.getStrTeacherInformationFirstName().equals("")) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(teacher.get(TeacherInformation_.strTeacherInformationFirstName)),
                    SQLUtil.AllLike(searchReq.getStrTeacherInformationFirstName())));
        }
        if(searchReq.getStrTeacherInformationLastName()!= null &&!searchReq.getStrTeacherInformationLastName().equals("")) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(teacher.get(TeacherInformation_.strTeacherInformationLastName)),
                    SQLUtil.AllLike(searchReq.getStrTeacherInformationLastName())));
        }
        if(searchReq.getStrSubjectInformationName()!= null && !searchReq.getStrSubjectInformationName().equals("")) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(subject.get(SubjectInformation_.strSubjectInformationName)),
                    SQLUtil.AllLike(searchReq.getStrSubjectInformationName())));
        }

        if(searchReq.getDtExaminationDay() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.function("date", Date.class,entityRoot.get(ExaminationInformation_.dtExaminationDay)),
                    searchReq.getDtExaminationDay()));
        }
        return predicates ;
    }
    @Override
    public long count(ExaminationInformationSearchReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<ExaminationInformation> entityRoot = criteriaQuery.from(ExaminationInformation.class);
        final Join<ExaminationInformation,RateOfDifficulty>
                difficulty = entityRoot.join(ExaminationInformation_.rateOfDifficultyByIRateOfDifficultyPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,TeacherInformation>
                teacher= entityRoot.join(ExaminationInformation_.teacherInformationByITeacherInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,SubjectInformation>
                subject= entityRoot.join(ExaminationInformation_.subjectInformationByISubjectInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,ExaminationRoom>
                room= entityRoot.join(ExaminationInformation_.examinationRoomByIExaminationRoomPk
                , JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                difficulty,
                teacher,
                subject,
                room,
                searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public ExaminationInformationDto findByID(Integer iExaminationInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<ExaminationInformation> entityRoot = criteriaQuery.from(ExaminationInformation.class);
        final Join<ExaminationInformation,RateOfDifficulty>
                difficulty = entityRoot.join(ExaminationInformation_.rateOfDifficultyByIRateOfDifficultyPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,TeacherInformation>
                teacher= entityRoot.join(ExaminationInformation_.teacherInformationByITeacherInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,SubjectInformation>
                subject= entityRoot.join(ExaminationInformation_.subjectInformationByISubjectInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,ExaminationRoom>
                room= entityRoot.join(ExaminationInformation_.examinationRoomByIExaminationRoomPk
                , JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(ExaminationInformation_.iExaminationInformationPk),
                iExaminationInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(ExaminationInformation_.iExaminationInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                difficulty,teacher,subject,room)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        Tuple tuple ;
        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        try {
            tuple = query.getSingleResult();
            return convertToExaminationInformDto(tuple);
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }

    @Override
    public ExaminationInformation create(ExaminationInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public ExaminationInformation update(ExaminationInformationSaveReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iExaminationInformationPk) throws QuizException {

    }
}
