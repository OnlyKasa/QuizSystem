package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TestInformationSearchReq;
import com.ben.quiz.domain.dto.result.ExaminationInformationDetailDto;
import com.ben.quiz.domain.dto.result.TestInformationDto;
import com.ben.quiz.domain.model.*;
import com.ben.quiz.domain.repository.interfaces.TestInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Date;
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
        final Join<ExaminationInformation,SubjectInformation>
                subject= examination.join(ExaminationInformation_.subjectInformationByISubjectInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,ExaminationRoom>
                room= examination.join(ExaminationInformation_.examinationRoomByIExaminationRoomPk
                , JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                teacher,
                examination,
                subject,
                searchReq);

        criteriaQuery.multiselect(entityRoot,
                teacher,examination,subject,room)
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
        for(int i= 0 ;i< tuple.toArray().length;i++){
            if(tuple.get(i) !=null){
                modelMapper.map(tuple.get(i),questionInformDto);
            }
        }
        return questionInformDto;
    }
    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<TestInformation> entityRoot,
                                                             Join<TestInformation,StudentInformation> student,
                                                             Join<TestInformation,ExaminationInformation> examination,
                                                             Join<ExaminationInformation,SubjectInformation> subject,
                                                             TestInformationSearchReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(student.get(StudentInformation_.iStudentInformationCode)),
                SQLUtil.AllLike(searchReq.getiStudentInformationCode())));

        if( searchReq.getStrExaminationInformationCode() != null)
            predicates.add(criteriaBuilder.equal(examination.get(ExaminationInformation_.strExaminationInformationCode),
                searchReq.getStrExaminationInformationCode()));

        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(student.get(StudentInformation_.strStudentInformationFirstName)),
                SQLUtil.AllLike(searchReq.getStrStudentInformationFirstName())));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(student.get(StudentInformation_.strStudentInformationLastName)),
                SQLUtil.AllLike(searchReq.getStrStudentInformationLastName())));

        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(subject.get(SubjectInformation_.strSubjectInformationName)),
                SQLUtil.AllLike(searchReq.getStrSubjectInformationName())));

        predicates.add(criteriaBuilder.equal((student.get(StudentInformation_.iStudentInformationPk)), searchReq.getiStudentInformationPk()));
        if(searchReq.getDtExaminationDay() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.function("date", Date.class,examination.get(ExaminationInformation_.dtExaminationDay)),
                    searchReq.getDtExaminationDay()));
        }
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
        final Join<ExaminationInformation,SubjectInformation>
                subject= examination.join(ExaminationInformation_.subjectInformationByISubjectInformationPk
                , JoinType.LEFT);
        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,
                entityRoot,
                teacher,
                examination,
                subject,
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
        final Join<ExaminationInformation,SubjectInformation>
                subject= examination.join(ExaminationInformation_.subjectInformationByISubjectInformationPk
                , JoinType.LEFT);
        final Join<ExaminationInformation,ExaminationRoom>
                room= examination.join(ExaminationInformation_.examinationRoomByIExaminationRoomPk
                , JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformation_.iTestInformationPk),
                iTestInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,
                teacher,examination,subject,room)
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

    @Override
    public List<ExaminationInformationDetailDto> findTestByExaminationID(Integer iExaminationInformationPk,
                                                                   PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        final Root<TestInformation> entityRoot = criteriaQuery.from(TestInformation.class);
        final Join<TestInformation,StudentInformation>
                student = entityRoot.join(TestInformation_.studentInformationByIStudentInformationPk,
                JoinType.LEFT);
        final Join<StudentInformation,FacultyInformation>
                faculty = student.join(StudentInformation_.facultyInformationByIFacultyInformationPk,JoinType.LEFT);


        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformation_.iExaminationInformationPk),
                iExaminationInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));

        criteriaQuery.multiselect(entityRoot,student,faculty)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<ExaminationInformationDetailDto>examinationInformationDetailDtos = new ArrayList<>() ;
        List<Tuple> tuples = query.getResultList();
        for (Tuple tuple:tuples) {
            examinationInformationDetailDtos.add(convertToDetailExaminationDto(tuple));
        }

        return examinationInformationDetailDtos;
    }

    private ExaminationInformationDetailDto convertToDetailExaminationDto(Tuple tuple){
        ExaminationInformationDetailDto examinationInformationDetailDto = new ExaminationInformationDetailDto();
        modelMapper.map(tuple.get(0),examinationInformationDetailDto);
        modelMapper.map(tuple.get(1),examinationInformationDetailDto);
        modelMapper.map(tuple.get(2),examinationInformationDetailDto);
        return  examinationInformationDetailDto;
    }

    @Override
    public long countTestByExaminationID(Integer iExaminationInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<TestInformation> entityRoot = criteriaQuery.from(TestInformation.class);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformation_.iExaminationInformationPk),
                iExaminationInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));

        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public ExaminationInformationDetailDto findByStudentPkAndExaminationPk(Integer iStudentInformationPk, Integer iExaminationInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<TestInformation> criteriaQuery = criteriaBuilder.createQuery(TestInformation.class);
        final Root<TestInformation> entityRoot = criteriaQuery.from(TestInformation.class);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformation_.iStudentInformationPk),
                iStudentInformationPk));
        predicates.add(criteriaBuilder.equal(entityRoot.get(TestInformation_.iExaminationInformationPk),
                iExaminationInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(TestInformation_.iTestInformationPkEk)));

        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<TestInformation> query = entityManager.createQuery(criteriaQuery);
        try {
            return (convertToDto( query.getSingleResult()));
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }

    private ExaminationInformationDetailDto convertToDto(TestInformation testInformation){

      return   modelMapper.map(testInformation,ExaminationInformationDetailDto.class);
    }


}
