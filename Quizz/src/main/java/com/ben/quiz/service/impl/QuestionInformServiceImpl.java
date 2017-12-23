package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.QuestionInformSaveReq;
import com.ben.quiz.domain.dto.request.QuestionInformSearchReq;
import com.ben.quiz.domain.dto.result.QuestionInformDto;
import com.ben.quiz.domain.dto.result.TeacherInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.QuestionInformation;
import com.ben.quiz.domain.model.SubjectInformation;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.domain.repository.interfaces.*;
import com.ben.quiz.service.interfaces.QuestionInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service("questionService")
public class QuestionInformServiceImpl implements QuestionInformService {

    private  QuestionInformRepository questionInformRepository ;
    private TeacherInformRepository teacherInformRepository;
    private  SubjectInformRepository subjectInformRepository;
    private ModelMapper modelMapper;
    private  UtilRepository utilRepository ;

    @Autowired
    public QuestionInformServiceImpl(QuestionInformRepository questionInformRepository,
                                     TeacherInformRepository teacherInformRepository,
                                     SubjectInformRepository subjectInformRepository,
                                     UtilRepository utilRepository,
                                     ModelMapper modelMapper) {
        this.questionInformRepository = questionInformRepository;
        this.teacherInformRepository = teacherInformRepository;
        this.subjectInformRepository = subjectInformRepository;
        this.modelMapper = modelMapper;
        this.utilRepository = utilRepository;
    }
    @Transactional(readOnly = true)
    @Override
    public List<QuestionInformDto> search(QuestionInformSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return questionInformRepository.search(searchReq,pagingReq);
    }
    @Transactional(readOnly = true)
    @Override
    public long count(QuestionInformSearchReq searchReq) throws QuizException {
        return questionInformRepository.count(searchReq);
    }
    @Transactional(readOnly = true)
    @Override
    public QuestionInformDto findByID(Integer iQuestionInformationPk) throws QuizException {
        return questionInformRepository.findByID(iQuestionInformationPk);
    }
    @Transactional(readOnly = true)
    @Override
    public List<QuestionInformDto> findByTeacherInformationPk(Integer iTeacherInformationPk) throws QuizException {
        TeacherInformation teacherInformation = modelMapper.map(
                teacherInformRepository.findByID(iTeacherInformationPk), TeacherInformation.class);

        List<QuestionInformation> questionInformations = (List<QuestionInformation>)
                teacherInformation.getQuestionInformationsByITeacherInformationPk();
        List<QuestionInformDto> questionInformDtos = new ArrayList<>();
        for (QuestionInformation questionInformation:questionInformations) {
            questionInformDtos.add(convertToQuestionInformDtoFormTeacher(questionInformation,teacherInformation));
        }
        return questionInformDtos;
    }
    private QuestionInformDto convertToQuestionInformDtoFormTeacher(QuestionInformation questionInformation,
                                                       TeacherInformation teacherInformation){
        QuestionInformDto questionInformDto =new QuestionInformDto();
        modelMapper.map(questionInformation,questionInformDto);
        modelMapper.map(teacherInformation,questionInformDto);
        return questionInformDto;
    }

    private QuestionInformDto convertToQuestionInformDtoFromSubject(QuestionInformation questionInformation,
                                                         SubjectInformation subjectInformation){
        QuestionInformDto questionInformDto =new QuestionInformDto();
        modelMapper.map(questionInformation,questionInformDto);
        modelMapper.map(subjectInformation,questionInformDto);
        return questionInformDto;
    }
    @Transactional(readOnly = true)
    @Override
    public List<QuestionInformDto> findBySubjectInformationPk(Integer iSubjectInformationPk) throws QuizException {
        SubjectInformation subjectInformation = modelMapper.map(
                teacherInformRepository.findByID(iSubjectInformationPk), SubjectInformation.class);

        List<QuestionInformation> questionInformations = (List<QuestionInformation>)
                subjectInformation.getQuestionInformationsByISubjectInformationPk();
        List<QuestionInformDto> questionInformDtos = new ArrayList<>();
        for (QuestionInformation questionInformation:questionInformations) {
            questionInformDtos.add(convertToQuestionInformDtoFromSubject(questionInformation,subjectInformation));
        }
        return questionInformDtos;
    }
    @Transactional
    @Override
    public QuestionInformation create(QuestionInformSaveReq saveReq) throws QuizException {
        saveReq.setiQuestionInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.QUESTION_INFORMATION_SEQ).intValue());

        saveReq.setiQuestionInformationPkEk(saveReq.getiQuestionInformationPk());
        QuestionInformation questionInformation = modelMapper.map(saveReq ,QuestionInformation.class);
        if((saveReq.getiTeacherInformationPk() != 0) || saveReq.getiTeacherInformationPk() !=null) {
            questionInformation.setTeacherInformationByITeacherInformationPk(
                    teacherInformRepository.findOne(TeacherInformation.class,
                                                    saveReq.getiTeacherInformationPk()));
        }
        if((saveReq.getiSubjectInformationPk() != 0) || saveReq.getiSubjectInformationPk() !=null) {
            questionInformation.setSubjectInformationByISubjectInformationPk(subjectInformRepository.findOne(SubjectInformation.class,
                            saveReq.getiTeacherInformationPk()));
        }

        return teacherInformRepository.add(questionInformation);
    }
    @Transactional
    @Override
    public QuestionInformation update(QuestionInformSaveReq saveReq) throws QuizException {
        QuestionInformDto questionInformDto = questionInformRepository.findByID(
                saveReq.getiTeacherInformationPk());
        QuestionInformation questionInformation = new QuestionInformation();

        modelMapper.map(saveReq,questionInformDto);
        modelMapper.map(questionInformDto,questionInformation);
        if((saveReq.getiSubjectInformationPk() != 0) || saveReq.getiSubjectInformationPk() !=null)
        {
            questionInformation.setSubjectInformationByISubjectInformationPk(
                    subjectInformRepository.findOne(SubjectInformation.class,saveReq.getiSubjectInformationPk()));
        }
        if((saveReq.getiTeacherInformationPk() != 0) || saveReq.getiTeacherInformationPk() !=null)
        {
            questionInformation.setTeacherInformationByITeacherInformationPk(
                    teacherInformRepository.findOne(TeacherInformation.class,saveReq.getiSubjectInformationPk()));
        }
        questionInformation.setiQuestionInformationPkEk(questionInformation.getiQuestionInformationPk());
        return teacherInformRepository.save(questionInformation);
    }
    @Transactional
    @Override
    public void delete(Integer iQuestionInformationPk) throws QuizException {
        QuestionInformation questionInformation = modelMapper.map(questionInformRepository.findByID(
                iQuestionInformationPk),QuestionInformation.class);

        questionInformation.setiQuestionInformationPkEk(null);
        teacherInformRepository.save(questionInformation);
    }
}
