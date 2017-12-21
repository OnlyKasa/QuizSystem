package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.ExaminationInformation;
import com.ben.quiz.domain.model.ExaminationInformationDetail;
import com.ben.quiz.domain.model.ExaminationInformationDetail_;
import com.ben.quiz.domain.model.StudentInformation;
import com.ben.quiz.domain.repository.interfaces.ExaminationInformDetailRepository;
import com.ben.quiz.domain.repository.interfaces.ExaminationInformRepository;
import com.ben.quiz.domain.repository.interfaces.StudentInformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository("examinationDetailRepository")
public class ExaminationInformDetailRepositoryImpl extends BaseRepositoryImpl
        implements ExaminationInformDetailRepository{

    private  StudentInformRepository studentInformRepository ;

    private  ExaminationInformRepository examinationInformRepository;

    @Autowired
    public ExaminationInformDetailRepositoryImpl(StudentInformRepository studentInformRepository,
                                                 ExaminationInformRepository examinationInformRepository) {
        this.studentInformRepository = studentInformRepository;
        this.examinationInformRepository = examinationInformRepository;
    }

    @Override
    public List<ExaminationInformationDetail> findByStudent(Integer iStudentInformationPk) throws QuizException {

        StudentInformation studentInformation = studentInformRepository.findOne(StudentInformation.class,iStudentInformationPk);

        return (List<ExaminationInformationDetail>)
                studentInformation.getExaminationInformationDetailsByIStudentInformationPk();
    }

    @Override
    public List<ExaminationInformationDetail> findByExamination(Integer iExaminationInformationPk) throws QuizException {

        ExaminationInformation examinationInformation = examinationInformRepository.findOne(ExaminationInformation.class,iExaminationInformationPk);

        return (List<ExaminationInformationDetail>)
                examinationInformation.getExaminationInformationDetailsByIExaminationInformationPk();
    }

    @Override
    public ExaminationInformationDetail findByStudentPkAndExaminationPk(Integer iStudentInformationPk, Integer iExaminationInformationPk) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ExaminationInformationDetail> criteriaQuery = criteriaBuilder.createQuery(ExaminationInformationDetail.class);
        final Root<ExaminationInformationDetail> entityRoot = criteriaQuery.from(ExaminationInformationDetail.class);

        List<Predicate> predicates = new ArrayList<>() ;
        predicates.add(criteriaBuilder.equal(entityRoot.get(ExaminationInformationDetail_.iStudentInformationPk),
                iStudentInformationPk));
        predicates.add(criteriaBuilder.equal(entityRoot.get(ExaminationInformationDetail_.iExaminationInformationPk),
                iExaminationInformationPk));
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(ExaminationInformationDetail_.iExaminationInformationDetailPkEk)));

        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<ExaminationInformationDetail> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        }catch (Exception e){
            throw new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
    }

}
