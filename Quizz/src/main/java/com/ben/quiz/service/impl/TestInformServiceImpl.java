package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TestInformationSaveReq;
import com.ben.quiz.domain.dto.request.TestInformationSearchReq;
import com.ben.quiz.domain.dto.result.TestInformationDetailDto;
import com.ben.quiz.domain.dto.result.TestInformationDto;
import com.ben.quiz.domain.model.*;
import com.ben.quiz.domain.repository.interfaces.*;
import com.ben.quiz.service.interfaces.TestInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("testService")
public class TestInformServiceImpl implements TestInformService {

    private ModelMapper modelMapper;
    private UtilRepository utilRepository;
    private UserRepository userRepository;
    private TestInformRepository testInformRepository;
    private StudentInformRepository studentInformRepository;
    private ExaminationInformRepository examinationInformRepository;
    private QuestionInformRepository questionInformRepository ;
    private TestInformationDetailRepository testInformationDetailRepository;

    @Autowired
    public TestInformServiceImpl(ModelMapper modelMapper,
                                 UtilRepository utilRepository,
                                 UserRepository userRepository,
                                 TestInformRepository testInformRepository,
                                 StudentInformRepository studentInformRepository,
                                 ExaminationInformRepository examinationInformRepository,
                                 QuestionInformRepository questionInformRepository,
                                 TestInformationDetailRepository testInformationDetailRepository) {
        this.modelMapper = modelMapper;
        this.utilRepository = utilRepository;
        this.userRepository = userRepository;
        this.testInformRepository = testInformRepository;
        this.studentInformRepository =studentInformRepository;
        this.examinationInformRepository =examinationInformRepository;
        this.questionInformRepository = questionInformRepository;
        this.testInformationDetailRepository = testInformationDetailRepository;
    }

    @Override
    public List<TestInformationDto> search(TestInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return testInformRepository.search(searchReq,pagingReq);
    }

    @Override
    public long count(TestInformationSearchReq searchReq) throws QuizException {
        return testInformRepository.count(searchReq);
    }

    @Override
    public TestInformationDto findByID(Integer iTestInformationPk) throws QuizException {
        return testInformRepository.findByID(iTestInformationPk);
    }

    @Override
    public List<TestInformationDto> findByStudentPk(Integer iStudentInformationPk) throws QuizException {
        List<TestInformationDto> testInformationDtos = new ArrayList<>();
        StudentInformation studentInformation =  studentInformRepository.findOne(StudentInformation.class,iStudentInformationPk);
        List<TestInformation> testInformations = (List<TestInformation>)
                studentInformation.getTestInformationsByIStudentInformationPk();
        for (TestInformation testInformation:testInformations) {
            testInformationDtos.add(convertToTestInformDtoFromStudent(testInformation,studentInformation));
        }
        return testInformationDtos;
    }

    @Override
    public List<TestInformationDto> findByExaminationPk(Integer iExaminationInformationPk) throws QuizException {
        List<TestInformationDto> testInformationDtos = new ArrayList<>();
        ExaminationInformation examinationInformation = examinationInformRepository.findOne(
                ExaminationInformation.class,iExaminationInformationPk);
        List<TestInformation> testInformations = (List<TestInformation>)
                examinationInformation.getTestInformationsByIExaminationInformationPk();
        for (TestInformation testInformation:testInformations) {
            testInformationDtos.add(convertToTestInformDtoFromExamination(testInformation,examinationInformation));
        }
        return testInformationDtos;
    }

    private TestInformationDto convertToTestInformDtoFromStudent(TestInformation testInformation,
                                                       StudentInformation studentInformation){
        TestInformationDto testInformationDto =new TestInformationDto();
        modelMapper.map(testInformation,testInformationDto);
        testInformation.setStudentInformationByIStudentInformationPk(studentInformation);
        modelMapper.map(studentInformation,testInformationDto);
        return testInformationDto;
    }
    private TestInformationDto convertToTestInformDtoFromExamination(TestInformation testInformation,
                                                                 ExaminationInformation examinationInformation){
        TestInformationDto testInformationDto =new TestInformationDto();
        modelMapper.map(testInformation,testInformationDto);
        modelMapper.map(examinationInformation,testInformationDto);
        return testInformationDto;
    }

    @Override
    public TestInformation create(TestInformationSaveReq saveReq) throws QuizException {
        saveReq.setiTestInformationPk(
            utilRepository.findSequenceNextval(SequenceConst.TEST_INFORMATION_SEQ).intValue());

        saveReq.setiTestInformationPkEk(saveReq.getiTestInformationPk());
        TestInformation testInformation = modelMapper.map(saveReq ,TestInformation.class);
        if((saveReq.getiStudentInformationPk() != 0) || saveReq.getiStudentInformationPk() !=null) {
            testInformation.setStudentInformationByIStudentInformationPk(
                    studentInformRepository.findOne(StudentInformation.class,saveReq.getiStudentInformationPk()));
        }
        if((saveReq.getiExaminationInformationPk() != 0) || saveReq.getiExaminationInformationPk() != null) {
            testInformation.setExaminationInformationByIExaminationInformationPk(
                    examinationInformRepository.findOne(ExaminationInformation.class,saveReq.getiExaminationInformationPk()));
        }
        return testInformRepository.add(testInformation);
    }

    @Override
    public TestInformation update(TestInformationSaveReq saveReq) throws QuizException {

        TestInformation testInformation = new TestInformation();
        TestInformationDto testInformationDto = testInformRepository.findByID(
                saveReq.getiTestInformationPk());

        modelMapper.map(saveReq,testInformationDto);
        modelMapper.map(testInformationDto,testInformation);
        if((saveReq.getiStudentInformationPk() != 0) || saveReq.getiStudentInformationPk() !=null)
        {
            testInformation.setStudentInformationByIStudentInformationPk(
                    studentInformRepository.findOne(StudentInformation.class,saveReq.getiStudentInformationPk()));
        }
        if((saveReq.getiExaminationInformationPk() != 0) || saveReq.getiExaminationInformationPk() !=null)
        {
            testInformation.setExaminationInformationByIExaminationInformationPk(
                    examinationInformRepository.findOne(ExaminationInformation.class,saveReq.getiExaminationInformationPk()));
        }
        testInformation.setiTestInformationPkEk(testInformation.getiTestInformationPk());

        return testInformRepository.save(testInformation);
    }


    @Override
    public void delete(Integer iTestInformationPk) throws QuizException {
        TestInformation testInformation = modelMapper.map(testInformRepository.findByID(
                iTestInformationPk),TestInformation.class);

        testInformation.setiTestInformationPkEk(null);
        testInformRepository.save(testInformation);
    }

    @Override
    public List<TestInformationDetailDto> findByTestID(Integer iTestInformationPk, PagingReq pagingReq) throws QuizException {
        return testInformationDetailRepository.findByTestInformationPk(iTestInformationPk,pagingReq);
    }

    @Override
    public long countByTestID(Integer iTestInformationPk) throws QuizException {
        return testInformationDetailRepository.countByTestID(iTestInformationPk);
    }


}
