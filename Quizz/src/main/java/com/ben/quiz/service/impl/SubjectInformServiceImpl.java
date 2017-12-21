package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.SubjectInformationSaveReq;
import com.ben.quiz.domain.dto.request.SubjectInformationSearchReq;
import com.ben.quiz.domain.dto.result.SubjectInformationDto;
import com.ben.quiz.domain.model.SubjectInformation;
import com.ben.quiz.domain.repository.interfaces.SubjectInformRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.SubjectInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("subjectService")
public class SubjectInformServiceImpl implements SubjectInformService {


    private final SubjectInformRepository subjectInformRepository ;
    private final UtilRepository utilRepository ;
    private  ModelMapper modelMapper;

    @Autowired
    public SubjectInformServiceImpl(SubjectInformRepository subjectInformRepository,
                                    UtilRepository utilRepository,
                                    ModelMapper modelMapper) {
        this.subjectInformRepository = subjectInformRepository;
        this.utilRepository = utilRepository;
        this.modelMapper = modelMapper;
    }
    @Transactional(readOnly = true)
    @Override
    public List<SubjectInformationDto> search(SubjectInformationSearchReq searchReq,
                                              PagingReq pagingReq) throws QuizException {
        return subjectInformRepository.search(searchReq,pagingReq);
    }
    @Transactional(readOnly = true)
    @Override
    public long count(SubjectInformationSearchReq searchReq) throws QuizException {
        return subjectInformRepository.count(searchReq);
    }
    @Transactional(readOnly = true)
    @Override
    public SubjectInformationDto findByID(Integer iSubjectInformationPk) throws QuizException {
        return subjectInformRepository.findByID(iSubjectInformationPk);
    }

    @Override
    @Transactional
    public SubjectInformation create(SubjectInformationSaveReq saveReq) throws QuizException {
        saveReq.setiSubjectInformationPk(
                utilRepository.findSequenceNextval(SequenceConst.SUBJECT_INFORMATION_SEQ).intValue());

        saveReq.setiSubjectInformationPkEk(saveReq.getiSubjectInformationPk());
        SubjectInformation subjectInformation = modelMapper.map(saveReq ,SubjectInformation.class);

        return subjectInformRepository.add(subjectInformation);

    }

    @Override
    @Transactional
    public SubjectInformation update(SubjectInformationSaveReq saveReq) throws QuizException {
        SubjectInformationDto subjectInformationDto = subjectInformRepository.findByID(
                saveReq.getiSubjectInformationPk());
        saveReq.setiSubjectInformationPkEk(subjectInformationDto.getiSubjectInformationPkEk());
        SubjectInformation subjectInformation = new SubjectInformation();
        modelMapper.map(saveReq,subjectInformation);
        return subjectInformRepository.save(subjectInformation);
    }

    @Override
    @Transactional
    public void delete(Integer iSubjectInformationPk) throws QuizException {
        SubjectInformation subjectInformation = modelMapper.map(subjectInformRepository.findByID(
                iSubjectInformationPk),SubjectInformation.class);

        subjectInformation.setiSubjectInformationPkEk(null);
        subjectInformRepository.save(subjectInformation);
    }
}
