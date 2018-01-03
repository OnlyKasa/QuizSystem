package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.AuthorityConst;
import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.PasswordUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.StudentInformationSaveReq;
import com.ben.quiz.domain.dto.request.StudentInformationSearchReq;
import com.ben.quiz.domain.dto.result.StudentInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.Seiuser;
import com.ben.quiz.domain.model.StudentInformation;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.domain.repository.interfaces.FacultyInformRepository;
import com.ben.quiz.domain.repository.interfaces.StudentInformRepository;
import com.ben.quiz.domain.repository.interfaces.UserRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.StudentInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service("studentService")
public class StudentInformServiceImpl implements StudentInformService {

    private final StudentInformRepository studentInformRepository ;
    private  ModelMapper modelMapper ;
    private final FacultyInformRepository facultyInformRepository ;
    private final UtilRepository utilRepository;
    private final UserRepository userRepository;
    @Autowired
    public StudentInformServiceImpl(StudentInformRepository studentInformRepository,
                                    FacultyInformRepository facultyInformRepository,
                                    UtilRepository utilRepository,
                                    ModelMapper modelMapper,
                                    UserRepository userRepository){
        this.studentInformRepository = studentInformRepository;
        this.modelMapper = modelMapper;
        this.facultyInformRepository = facultyInformRepository;
        this.utilRepository = utilRepository;
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    @Override
    public List<StudentInformDto> search(StudentInformationSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return studentInformRepository.search(searchReq,pagingReq);
    }
    @Transactional(readOnly = true)
    @Override
    public long count(StudentInformationSearchReq searchReq) throws QuizException {
        return studentInformRepository.count(searchReq);
    }
    @Transactional(readOnly = true)
    @Override
    public StudentInformDto findByID(Integer iStudentInformationPk) throws QuizException {
        return studentInformRepository.findByID(iStudentInformationPk);
    }
    @Transactional(readOnly = true)
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
    @Transactional
    public StudentInformation create(StudentInformationSaveReq saveReq) throws QuizException {
        saveReq.setiStudentInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.STUDENT_INFORMATION_SEQ).intValue());
        if(saveReq.getUserId() == null || saveReq.getPassword()== null){
            throw new QuizException(CodeConst.ErrorCode.Err_Not_Null, CodeConst.ErrorMess.Err_Not_Null);
        }
        Seiuser seiuser = new Seiuser();
        if(!userRepository.isExistUserid(saveReq.getUserId())){
            seiuser.setiStudentInformationPk(saveReq.getiStudentInformationPk());
            seiuser.setUserId(saveReq.getUserId());
            seiuser.setPassword(PasswordUtil.genSHAForPassword(saveReq.getPassword()));
            seiuser.setTopMenu(AuthorityConst.STU.CODE);
            userRepository.add(seiuser);
        }

        saveReq.setiStudentInformationPkEk(saveReq.getiStudentInformationPkEk());
        StudentInformation studentInformation = modelMapper.map(saveReq ,StudentInformation.class);
        if((saveReq.getiFacultyInformationPk() != 0) || saveReq.getiFacultyInformationPk() !=null) {
            studentInformation.setFacultyInformationByIFacultyInformationPk(
                    facultyInformRepository.findByID(saveReq.getiFacultyInformationPk()));
        }
        return studentInformRepository.add(studentInformation);
    }

    @Override
    @Transactional
    public StudentInformation update(StudentInformationSaveReq studentInformationSaveReq) throws QuizException {
        StudentInformDto studentInformDto = studentInformRepository.findByID(
                studentInformationSaveReq.getiStudentInformationPk());

        StudentInformation studentInformation = new StudentInformation();
        if(studentInformationSaveReq.getUserId() == null){
            throw new QuizException(CodeConst.ErrorCode.Err_Not_Null, CodeConst.ErrorMess.Err_Not_Null);
        }
        Seiuser seiuser;
        if(userRepository.isExistUserid(studentInformationSaveReq.getUserId())){
            seiuser = userRepository.findSeiuserByUserid(studentInformationSaveReq.getUserId());
            String oldPass = seiuser.getPassword() ;
            if(!Objects.equals(oldPass, PasswordUtil.genSHAForPassword(studentInformationSaveReq.getPassword()))) {
                seiuser.setPassword(PasswordUtil.genSHAForPassword(studentInformationSaveReq.getPassword()));
                userRepository.save(seiuser);
            }

        }
        modelMapper.map(studentInformationSaveReq,studentInformDto);
        modelMapper.map(studentInformDto,studentInformation);
        if((studentInformationSaveReq.getiFacultyInformationPk() != 0) || studentInformationSaveReq.getiFacultyInformationPk() !=null)
        {
            studentInformation.setFacultyInformationByIFacultyInformationPk(
                    facultyInformRepository.findByID(studentInformationSaveReq.getiFacultyInformationPk()));
        }
        studentInformation.setiStudentInformationPkEk(studentInformation.getiStudentInformationPk());
        return studentInformRepository.save(studentInformation);
    }

    @Override
    @Transactional
    public void delete(Integer iStudentInformationPk) throws QuizException {
        TeacherInformation teacherInformation = modelMapper.map(studentInformRepository.findByID(
                iStudentInformationPk),TeacherInformation.class);

        teacherInformation.setiTeacherInformationPkEk(null);
        studentInformRepository.save(teacherInformation);
    }
}
