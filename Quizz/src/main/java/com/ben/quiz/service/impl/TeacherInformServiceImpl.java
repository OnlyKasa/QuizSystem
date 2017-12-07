package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSaveReq;
import com.ben.quiz.domain.dto.request.TeacherInformationSearchReq;
import com.ben.quiz.domain.dto.result.TeacherInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.domain.repository.interfaces.FacultyInformRepository;
import com.ben.quiz.domain.repository.interfaces.TeacherInformRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.TeacherInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("teacher")
public class TeacherInformServiceImpl implements TeacherInformService {

    private final TeacherInformRepository teacherInformRepository ;
    private final FacultyInformRepository facultyInformRepository;
    private  ModelMapper modelMapper;
    private final UtilRepository utilRepository ;
    @Autowired
    public TeacherInformServiceImpl(TeacherInformRepository teacherInformRepository,
                                    FacultyInformRepository facultyInformRepository,
                                    UtilRepository utilRepository,
                                    ModelMapper modelMapper) {
        this.teacherInformRepository = teacherInformRepository;
        this.facultyInformRepository = facultyInformRepository;
        this.modelMapper = modelMapper;
        this.utilRepository = utilRepository;
    }

    @Override
    public List<TeacherInformDto> search(TeacherInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return teacherInformRepository.search(searchReq,pagingReq);
    }

    @Override
    public long count(TeacherInformationSearchReq searchReq) throws QuizException {
        return teacherInformRepository.count(searchReq);
    }

    @Override
    public TeacherInformDto findByID(Integer iTeacherInformationPk) throws QuizException {
        return teacherInformRepository.findByID(iTeacherInformationPk);
    }

    @Override
    public List<TeacherInformDto> findByFacultyPk(Integer iFacultyInformationPk) throws QuizException {
        FacultyInformation facultyInformation = facultyInformRepository.findByID(iFacultyInformationPk);
        List<TeacherInformation> teacherInformations = (List<TeacherInformation>)
                facultyInformation.getTeacherInformationsByIFacultyInformationPk();
        List<TeacherInformDto> teacherInformDtos = new ArrayList<>();
        for (TeacherInformation teacherInformation:teacherInformations) {
            teacherInformDtos.add(convertToTeacherInformDto(teacherInformation,facultyInformation));
        }
        return teacherInformDtos;
    }
    private TeacherInformDto convertToTeacherInformDto(TeacherInformation teacherInformation,
                                                       FacultyInformation facultyInformation){
        TeacherInformDto teacherInformDto =new TeacherInformDto();
        modelMapper.map(teacherInformation,teacherInformDto);
        modelMapper.map(facultyInformation,teacherInformDto);
        return teacherInformDto;
    }


    @Transactional(readOnly = true)
    @Override
    public TeacherInformation create(TeacherInformationSaveReq saveReq) throws QuizException {
        saveReq.setiTeacherInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.TEACHER_INFORMATION_SEQ).intValue());


        saveReq.setiTeacherInformationPkEk(saveReq.getiTeacherInformationPk());
        TeacherInformation teacherInformation = modelMapper.map(saveReq ,TeacherInformation.class);
        if((saveReq.getiFacultyInformationPk() != 0) || saveReq.getiFacultyInformationPk() !=null) {
            teacherInformation.setFacultyInformationByIFacultyInformationPk(
                    facultyInformRepository.findByID(saveReq.getiFacultyInformationPk()));
        }
        return teacherInformRepository.add(teacherInformation);
    }
    @Transactional(readOnly = true)
    @Override
    public TeacherInformation update(TeacherInformationSaveReq saveReq) throws QuizException {
        TeacherInformDto teacherInformDto = teacherInformRepository.findByID(
                saveReq.getiTeacherInformationPk());
        if((saveReq.getiFacultyInformationPk() != 0) || saveReq.getiFacultyInformationPk() !=null)
        {
            teacherInformDto.setFacultyInformationByIFacultyInformationPk(
                    facultyInformRepository.findByID(saveReq.getiFacultyInformationPk()));
        }
        TeacherInformation teacherInformation = new TeacherInformation();

        modelMapper.map(saveReq,teacherInformDto);
        modelMapper.map(teacherInformDto,teacherInformation);
        teacherInformation.setiTeacherInformationPkEk(teacherInformation.getiTeacherInformationPk());
        return teacherInformRepository.save(teacherInformation);
    }
    @Transactional(readOnly = true)
    @Override
    public void delete(Integer iTeacherInformationPk) throws QuizException {
        TeacherInformation teacherInformation = modelMapper.map(teacherInformRepository.findByID(
                iTeacherInformationPk),TeacherInformation.class);

        teacherInformation.setiTeacherInformationPkEk(null);
        teacherInformRepository.save(teacherInformation);
    }
}
