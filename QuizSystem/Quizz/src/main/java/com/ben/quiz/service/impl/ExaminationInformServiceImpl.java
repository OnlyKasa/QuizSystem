package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.ExaminationInformationSaveReq;
import com.ben.quiz.domain.dto.request.ExaminationInformationSearchReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.ExaminationInformationDto;
import com.ben.quiz.domain.model.*;
import com.ben.quiz.domain.repository.interfaces.*;
import com.ben.quiz.service.interfaces.ExaminationInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Transactional
@Service("examinationService")
public class ExaminationInformServiceImpl implements ExaminationInformService {

    private ModelMapper modelMapper;
    private UtilRepository utilRepository;
    private UserRepository userRepository;
    private ExaminationInformRepository examinationInformRepository;
    private RoomInformRepository roomInformRepository;
    private SubjectInformRepository subjectInformRepository;
    private TeacherInformRepository teacherInformRepository;
    private RateOfDifficultyRepository rateOfDifficultyRepository;
    private StudentInformRepository studentInformRepository;
    private ExaminationInformDetailRepository examinationInformDetailRepository;


    @Autowired
    public ExaminationInformServiceImpl(ModelMapper modelMapper,
                                        UtilRepository utilRepository,
                                        UserRepository userRepository,
                                        ExaminationInformRepository examinationInformRepository,
                                        RoomInformRepository roomInformRepository,
                                        SubjectInformRepository subjectInformRepository,
                                        TeacherInformRepository teacherInformRepository,
                                        RateOfDifficultyRepository rateOfDifficultyRepository,
                                        StudentInformRepository studentInformRepository,
                                        ExaminationInformDetailRepository examinationInformDetailRepository) {
        this.modelMapper = modelMapper;
        this.utilRepository = utilRepository;
        this.userRepository = userRepository;
        this.examinationInformRepository =examinationInformRepository;
        this.roomInformRepository = roomInformRepository;
        this.subjectInformRepository = subjectInformRepository;
        this.teacherInformRepository = teacherInformRepository;
        this.rateOfDifficultyRepository = rateOfDifficultyRepository;
        this.studentInformRepository = studentInformRepository;
        this.examinationInformDetailRepository = examinationInformDetailRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExaminationInformationDto> search(ExaminationInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return examinationInformRepository.search(searchReq,pagingReq);
    }

    @Transactional(readOnly = true)
    @Override
    public long count(ExaminationInformationSearchReq searchReq) throws QuizException {
        return examinationInformRepository.count(searchReq);
    }

    @Transactional(readOnly = true)
    @Override
    public ExaminationInformationDto findByID(Integer iExaminationInformationPk) throws QuizException {
        return examinationInformRepository.findByID(iExaminationInformationPk);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExaminationInformationDto> findByDifficultyPk(Integer iRateOfDifficultyPk) throws QuizException {
        List<ExaminationInformationDto> examinationInformationDtos = new ArrayList<>();
        RateOfDifficulty rateOfDifficulty =  rateOfDifficultyRepository.findOne(RateOfDifficulty.class,iRateOfDifficultyPk);
        List<ExaminationInformation> examinationInformations = (List<ExaminationInformation>)
                rateOfDifficulty.getExaminationInformationsByIRateOfDifficultyPk();
        for (ExaminationInformation examinationInformation:examinationInformations) {
            examinationInformationDtos.add(convertToExaminationInformDtoFromDifficulty(examinationInformation,rateOfDifficulty));
        }
        return examinationInformationDtos;
    }
    private ExaminationInformationDto convertToExaminationInformDtoFromDifficulty(ExaminationInformation examinationInformation,
                                                                 RateOfDifficulty rateOfDifficulty){
        ExaminationInformationDto examinationInformationDto =new ExaminationInformationDto();
        modelMapper.map(examinationInformation,examinationInformationDto);
        examinationInformation.setRateOfDifficultyByIRateOfDifficultyPk(rateOfDifficulty);
        modelMapper.map(examinationInformation,examinationInformationDto);
        return examinationInformationDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExaminationInformationDto> findBySubjectPk(Integer iSubjectInformationPk) throws QuizException {
        List<ExaminationInformationDto> examinationInformationDtos = new ArrayList<>();
        SubjectInformation subjectInformation =  subjectInformRepository.findOne(SubjectInformation.class,iSubjectInformationPk);
        List<ExaminationInformation> examinationInformations = (List<ExaminationInformation>)
                subjectInformation.getExaminationInformationsByISubjectInformationPk();
        for (ExaminationInformation examinationInformation:examinationInformations) {
            examinationInformationDtos.add(convertToExaminationInformDtoFromSubject(examinationInformation,subjectInformation));
        }
        return examinationInformationDtos;
    }
    private ExaminationInformationDto convertToExaminationInformDtoFromSubject(ExaminationInformation examinationInformation,
                                                                           SubjectInformation subjectInformation){
        ExaminationInformationDto examinationInformationDto =new ExaminationInformationDto();
        modelMapper.map(examinationInformation,examinationInformationDto);
        examinationInformation.setSubjectInformationByISubjectInformationPk(subjectInformation);
        modelMapper.map(examinationInformation,examinationInformationDto);
        return examinationInformationDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExaminationInformationDto> findByTeacherPk(Integer iTeacherInformationPk) throws QuizException {
        List<ExaminationInformationDto> examinationInformationDtos = new ArrayList<>();
        TeacherInformation teacherInformation =  teacherInformRepository.findOne(TeacherInformation.class,iTeacherInformationPk);
        List<ExaminationInformation> examinationInformations = (List<ExaminationInformation>)
                teacherInformation.getExaminationInformationsByITeacherInformationPk();
        for (ExaminationInformation examinationInformation:examinationInformations) {
            examinationInformationDtos.add(convertToExaminationInformDtoFromTeacher(examinationInformation,teacherInformation));
        }
        return examinationInformationDtos;
    }
    private ExaminationInformationDto convertToExaminationInformDtoFromTeacher(ExaminationInformation examinationInformation,
                                                                               TeacherInformation teacherInformation){
        ExaminationInformationDto examinationInformationDto =new ExaminationInformationDto();
        modelMapper.map(examinationInformation,examinationInformationDto);
        examinationInformation.setTeacherInformationByITeacherInformationPk(teacherInformation);
        modelMapper.map(examinationInformation,examinationInformationDto);
        return examinationInformationDto;
    }


    @Transactional(readOnly = true)
    @Override
    public List<ExaminationInformationDto> findByRoomPk(Integer iExaminationRoomPk) throws QuizException {
        List<ExaminationInformationDto> examinationInformationDtos = new ArrayList<>();
        ExaminationRoom examinationRoom =  roomInformRepository.findOne(ExaminationRoom.class,iExaminationRoomPk);
        List<ExaminationInformation> examinationInformations = (List<ExaminationInformation>)
                examinationRoom.getExaminationInformationsByIExaminationRoomPk();
        for (ExaminationInformation examinationInformation:examinationInformations) {
            examinationInformationDtos.add(convertToExaminationInformDtoFromRoom(examinationInformation,examinationRoom));
        }
        return examinationInformationDtos;
    }
    private ExaminationInformationDto convertToExaminationInformDtoFromRoom(ExaminationInformation examinationInformation,
                                                                               ExaminationRoom examinationRoom){
        ExaminationInformationDto examinationInformationDto =new ExaminationInformationDto();
        modelMapper.map(examinationInformation,examinationInformationDto);
        examinationInformation.setExaminationRoomByIExaminationRoomPk(examinationRoom);
        modelMapper.map(examinationInformation,examinationInformationDto);
        return examinationInformationDto;
    }

    @Override
    public ExaminationInformation create(ExaminationInformationSaveReq saveReq) throws QuizException {
        saveReq.setiExaminationInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.EXAMINATION_INFORMATION_SEQ).intValue());

        saveReq.setiExaminationInformationPk(saveReq.getiExaminationInformationPk());
        ExaminationInformation examinationInformation = modelMapper.map(saveReq ,ExaminationInformation.class);
        if((saveReq.getiExaminationRoomPk() != 0) || saveReq.getiExaminationRoomPk() !=null) {
            examinationInformation.setExaminationRoomByIExaminationRoomPk(
                    roomInformRepository.findOne(ExaminationRoom.class,saveReq.getiExaminationRoomPk()));
        }
        if((saveReq.getiRateOfDifficultyPk() != 0) || saveReq.getiRateOfDifficultyPk() != null) {
            examinationInformation.setRateOfDifficultyByIRateOfDifficultyPk(
                    rateOfDifficultyRepository.findOne(RateOfDifficulty.class,saveReq.getiRateOfDifficultyPk()));
        }
        if((saveReq.getiSubjectInformationPk() != 0) || saveReq.getiSubjectInformationPk() != null) {
            examinationInformation.setSubjectInformationByISubjectInformationPk(
                    rateOfDifficultyRepository.findOne(SubjectInformation.class,saveReq.getiSubjectInformationPk()));
        }
        if((saveReq.getiTeacherInformationPk() != 0) || saveReq.getiTeacherInformationPk() != null) {
            examinationInformation.setTeacherInformationByITeacherInformationPk(
                    teacherInformRepository.findOne(TeacherInformation.class,saveReq.getiTeacherInformationPk()));
        }


        CreateDetailExamination(saveReq.getListiStudentInformationPk(),saveReq.getiExaminationInformationPk());
        return examinationInformRepository.add(examinationInformation);
    }

    @Override
    public ExaminationInformation update(ExaminationInformationSaveReq saveReq) throws QuizException {
        ExaminationInformation examinationInformation = new ExaminationInformation();
        ExaminationInformationDto examinationInformationDto = examinationInformRepository.findByID(
                saveReq.getiExaminationInformationPk());

        modelMapper.map(saveReq,examinationInformation);
        modelMapper.map(examinationInformationDto,examinationInformation);
        examinationInformation.setiExaminationInformationPkEk(examinationInformation.getiExaminationInformationPk());
        UpdateListStudentForExaminationInformation(saveReq.getListiStudentInformationPk(),
                saveReq.getListDeleteiStudentInformationPk(),
                saveReq.getiExaminationInformationPk());
        return examinationInformRepository.save(examinationInformation);
    }

    @Transactional
    @Override
    public void delete(Integer iExaminationInformationPk) throws QuizException {
        ExaminationInformation examinationInformation = modelMapper.map(examinationInformRepository.findByID(
                iExaminationInformationPk),ExaminationInformation.class);

        examinationInformation.setiExaminationInformationPkEk(null);
        examinationInformRepository.save(examinationInformation);
    }

    @Override
    public List<ExaminationInformationDetail> findDetailExamination(Integer iExaminationInformationPk,PagingReq pagingReq) throws QuizException {
        return examinationInformDetailRepository.findByExamination(iExaminationInformationPk,pagingReq);
    }

    @Override
    public Long countDetailExamination(Integer iExaminationInformationPk) throws QuizException {
        return examinationInformDetailRepository.countByExamination(iExaminationInformationPk);
    }

    private void CreateDetailExamination(List<Integer> ListiStudentInformationPk,
                                         Integer iExaminationInformationPk) throws QuizException {

        for (Integer iStudentInformationPk :ListiStudentInformationPk) {
            ExaminationInformationDetail examinationInformationDetail = new ExaminationInformationDetail();
            examinationInformationDetail.setiExaminationInformationDetailPk(
                    utilRepository.findSequenceNextval(SequenceConst.EXAMINATION_INFORMATION_DETAIL_SEQ).intValue()
            );
            examinationInformationDetail.setiExaminationInformationDetailPkEk(examinationInformationDetail.getiExaminationInformationDetailPk());
            StudentInformation studentInformation = modelMapper.map(studentInformRepository.findByID(iStudentInformationPk),
                    StudentInformation.class);

            examinationInformationDetail.setStudentInformationByIStudentInformationPk(studentInformation);
            examinationInformationDetail.setiStudentInformationPk(studentInformation.getiStudentInformationPk());
            ExaminationInformation examinationInformation = modelMapper.map(examinationInformRepository.findByID(iExaminationInformationPk),
                    ExaminationInformation.class);

            examinationInformationDetail.setExaminationInformationByIExaminationInformationPk(examinationInformation);
            examinationInformationDetail.setiStudentInformationPk(examinationInformation.getiExaminationInformationPk());

            examinationInformDetailRepository.add(examinationInformationDetail);
        }

    }

    private void UpdateListStudentForExaminationInformation(List<Integer> listAddiStudentInformationPk,
                                                      List<Integer> listDeleteiStudentInformationPk,
                                                      Integer iExaminationInformationPk) throws QuizException {

        if(listAddiStudentInformationPk.size() != 0){
            CreateDetailExamination(listAddiStudentInformationPk,iExaminationInformationPk);
        }
        if(listDeleteiStudentInformationPk.size() != 0){
            for (Integer iStudentInformationPk :listDeleteiStudentInformationPk) {
                ExaminationInformationDetail examinationInformationDetail =
                        examinationInformDetailRepository.findByStudentPkAndExaminationPk(iStudentInformationPk,
                                iExaminationInformationPk);
                //TODO :  if error , may be result have 2 record
                examinationInformationDetail.setiExaminationInformationDetailPkEk(null);
                examinationInformDetailRepository.save(examinationInformationDetail);
            }
        }
    }
}
