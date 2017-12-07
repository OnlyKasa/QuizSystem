package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.StudentInformationSaveReq;
import com.ben.quiz.domain.dto.request.StudentInformationSearchReq;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.StudentInformation;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.domain.repository.interfaces.FacultyInformRepository;
import com.ben.quiz.domain.repository.interfaces.StudentInformRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.StudentInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("studentService")
public class StudentInformServiceImpl implements StudentInformService {

    private final StudentInformRepository studentInformRepository ;
    private  ModelMapper modelMapper ;
    private final FacultyInformRepository facultyInformRepository ;
    private final UtilRepository utilRepository;
    @Autowired
    public StudentInformServiceImpl(StudentInformRepository studentInformRepository,
                                    FacultyInformRepository facultyInformRepository,
                                    UtilRepository utilRepository,
                                    ModelMapper modelMapper ){
        this.studentInformRepository = studentInformRepository;
        this.modelMapper = modelMapper;
        this.facultyInformRepository = facultyInformRepository;
        this.utilRepository = utilRepository;
    }

    @Override
    public List<StudentInformDto> search(StudentInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return studentInformRepository.search(searchReq,pagingReq);
    }

    @Override
    public long count(StudentInformationSearchReq searchReq) throws QuizException {
        return studentInformRepository.count(searchReq);
    }

    @Override
    public StudentInformDto findByID(Integer iStudentInformationPk) throws QuizException {
        return studentInformRepository.findByID(iStudentInformationPk);
    }

    @Override
    public List<StudentInformDto> findByFacultyPk(Integer iFacultyInformationPk) throws QuizException {
        FacultyInformation facultyInformation = facultyInformRepository.findByID(iFacultyInformationPk);
        List<StudentInformation> studentInformations = (List<StudentInformation>)
                facultyInformation.getStudentInformationsByIFacultyInformationPk();
        List<StudentInformDto> teacherInformDtos = new ArrayList<>();
        for (StudentInformation studentInformation:studentInformations) {
            teacherInformDtos.add(convertToStudentInformDto(studentInformation,facultyInformation));
        }
        return teacherInformDtos;
    }

    private StudentInformDto convertToStudentInformDto(StudentInformation studentInformation,
                                                       FacultyInformation facultyInformation){
        StudentInformDto studentInformDto =new StudentInformDto();
        modelMapper.map(studentInformation,studentInformDto);
        modelMapper.map(facultyInformation,studentInformDto);
        return studentInformDto;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentInformation create(StudentInformationSaveReq saveReq) throws QuizException {
        saveReq.setiStudentInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.STUDENT_INFORMATION_SEQ).intValue());


        saveReq.setiStudentInformationPkEk(saveReq.getiStudentInformationPkEk());
        StudentInformation studentInformation = modelMapper.map(saveReq ,StudentInformation.class);
        if((saveReq.getiFacultyInformationPk() != 0) || saveReq.getiFacultyInformationPk() !=null) {
            studentInformation.setFacultyInformationByIFacultyInformationPk(
                    facultyInformRepository.findByID(saveReq.getiFacultyInformationPk()));
        }
        return studentInformRepository.add(studentInformation);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentInformation update(StudentInformationSaveReq saveReq) throws QuizException {
        StudentInformDto studentInformDto = studentInformRepository.findByID(
                saveReq.getiStudentInformationPk());
        if((saveReq.getiFacultyInformationPk() != 0) || saveReq.getiFacultyInformationPk() !=null)
        {
            studentInformDto.setFacultyInformationByIFacultyInformationPk(
                    facultyInformRepository.findByID(saveReq.getiFacultyInformationPk()));
        }
        StudentInformation studentInformation = new StudentInformation();

        modelMapper.map(saveReq,studentInformDto);
        modelMapper.map(studentInformDto,studentInformation);
        studentInformation.setiStudentInformationPkEk(studentInformation.getiStudentInformationPk());
        return studentInformRepository.save(studentInformation);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Integer iStudentInformationPk) throws QuizException {
        TeacherInformation teacherInformation = modelMapper.map(studentInformRepository.findByID(
                iStudentInformationPk),TeacherInformation.class);

        teacherInformation.setiTeacherInformationPkEk(null);
        studentInformRepository.save(teacherInformation);
    }
}
