package com.ben.quiz.service.impl;


import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RateOfDifficultyReq;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.RateOfDifficulty;
import com.ben.quiz.domain.repository.interfaces.RateOfDifficultyRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.RateOfDifficultyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("difficultyService")
public class RateOfDifficultyServiceImpl implements RateOfDifficultyService{

    private  UtilRepository utilRepository ;
    private  RateOfDifficultyRepository rateOfDifficultyRepository ;
    private ModelMapper modelMapper ;
    public RateOfDifficultyServiceImpl(UtilRepository utilRepository,
                                       RateOfDifficultyRepository rateOfDifficultyRepository,
                                       ModelMapper modelMapper) {
        this.utilRepository = utilRepository;
        this.rateOfDifficultyRepository = rateOfDifficultyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RateOfDifficulty> search(RateOfDifficultyReq searchReq, PagingReq pagingReq) throws QuizException {
        return rateOfDifficultyRepository.search(searchReq,pagingReq);
    }

    @Override
    public long count(RateOfDifficultyReq searchReq) throws QuizException {
        return rateOfDifficultyRepository.count(searchReq);
    }

    @Override
    public RateOfDifficulty findByID(Integer iRateOfDifficultyPk) throws QuizException {
        return rateOfDifficultyRepository.findByID(iRateOfDifficultyPk);
    }
    @Transactional(readOnly = true)
    @Override
    public RateOfDifficulty create(RateOfDifficultyReq saveReq) throws QuizException {
        saveReq.setiRateOfDifficultyPk(
                utilRepository.findSequenceNextval(SequenceConst.RATE_OF_DIFFICULTY_SEQ).intValue());
        saveReq.setiRateOfDifficultyPkEk(saveReq.getiRateOfDifficultyPk());
        RateOfDifficulty rateOfDifficulty = modelMapper.map(saveReq ,RateOfDifficulty.class);

        return rateOfDifficultyRepository.add(rateOfDifficulty);
    }
    @Transactional(readOnly = true)
    @Override
    public RateOfDifficulty update(RateOfDifficultyReq saveReq) throws QuizException {
        RateOfDifficulty rateOfDifficulty = rateOfDifficultyRepository.findByID(
                saveReq.getiRateOfDifficultyPk());

        modelMapper.map(saveReq,rateOfDifficulty);
        rateOfDifficulty.setiRateOfDifficultyPkEk(rateOfDifficulty.getiRateOfDifficultyPk());
        return rateOfDifficultyRepository.save(rateOfDifficulty);
    }
    @Transactional(readOnly = true)
    @Override
    public void delete(Integer iRateOfDifficultyPk) throws QuizException {
        RateOfDifficulty facultyInformation = rateOfDifficultyRepository.findByID(
                iRateOfDifficultyPk);
        facultyInformation.setiRateOfDifficultyPkEk(null);
        rateOfDifficultyRepository.save(facultyInformation);
    }
}
