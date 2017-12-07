package com.ben.quiz.service.impl;


import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.FacultyInformSearchReq;
import com.ben.quiz.domain.dto.request.FacultyInformationSaveReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.repository.interfaces.FacultyInformRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.FacultyInformService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("faculty")
public class FacultyInformServiceImpl implements FacultyInformService {

    private final FacultyInformRepository facultyInformRepository ;
    private final UtilRepository utilRepository ;
    private final ModelMapper modelMapper ;
    @Autowired
    public FacultyInformServiceImpl(FacultyInformRepository facultyInformRepository,
                                    UtilRepository utilRepository,
                                    ModelMapper modelMapper) {
        this.facultyInformRepository = facultyInformRepository;
        this.utilRepository = utilRepository ;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<FacultyInformDto> search(FacultyInformSearchReq searchReq, PagingReq pagingReq) throws QuizException {
        return facultyInformRepository.search(searchReq,pagingReq);
    }

    @Override
    public long count(FacultyInformSearchReq searchReq) throws QuizException {
        return facultyInformRepository.count(searchReq);
    }

    @Override
    public FacultyInformDto findByID(Integer iFacultyInformationPk) throws QuizException {
        return modelMapper.map(facultyInformRepository.findByID(iFacultyInformationPk),FacultyInformDto.class);
    }
    @Transactional(readOnly = true)
    @Override
    public FacultyInformation create(FacultyInformationSaveReq saveReq) throws QuizException {
        saveReq.setiFacultyInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.FACULTY_INFORMATION_SEQ).intValue());
        saveReq.setiFacultyInformationPkEk(saveReq.getiFacultyInformationPk());
        FacultyInformation facultyInformation = modelMapper.map(saveReq ,FacultyInformation.class);

        return facultyInformRepository.add(facultyInformation);
    }
    @Transactional(readOnly = true)
    @Override
    public FacultyInformation update(FacultyInformationSaveReq saveReq) throws QuizException {
        FacultyInformation facultyInformation = facultyInformRepository.findByID(
                saveReq.getiFacultyInformationPk());

        modelMapper.map(saveReq,facultyInformation);
        facultyInformation.setiFacultyInformationPkEk(facultyInformation.getiFacultyInformationPk());
        return facultyInformRepository.save(facultyInformation);
    }
    @Transactional(readOnly = true)
    @Override
    public void delete(Integer iFacultyInformationPk) throws QuizException {
        FacultyInformation facultyInformation = facultyInformRepository.findByID(
                iFacultyInformationPk);
        facultyInformation.setiFacultyInformationPkEk(null);
        facultyInformRepository.save(facultyInformation);
    }
}
