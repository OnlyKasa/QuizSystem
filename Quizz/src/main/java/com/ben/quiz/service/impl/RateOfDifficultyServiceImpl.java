package com.ben.quiz.service.impl;


import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RateOfDifficultyReq;
import com.ben.quiz.domain.dto.result.RateOfDifficultyDto;
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
    @Transactional(readOnly = true)
    @Override
    public List<RateOfDifficultyDto> search(RateOfDifficultyReq searchReq, PagingReq pagingReq) throws QuizException {
        return rateOfDifficultyRepository.search(searchReq,pagingReq);
    }

    @Transactional(readOnly = true)
    @Override
    public long count(RateOfDifficultyReq searchReq) throws QuizException {
        return rateOfDifficultyRepository.count(searchReq);
    }

    @Transactional(readOnly = true)
    @Override
    public RateOfDifficultyDto findByID(Integer iRateOfDifficultyPk) throws QuizException {
        return rateOfDifficultyRepository.findByID(iRateOfDifficultyPk);
    }

    @Transactional
    @Override
    public RateOfDifficulty create(RateOfDifficultyReq saveReq) throws QuizException {
        saveReq.setiRateOfDifficultyPk(
                utilRepository.findSequenceNextval(SequenceConst.RATE_OF_DIFFICULTY_SEQ).intValue());
        saveReq.setiRateOfDifficultyPkEk(saveReq.getiRateOfDifficultyPk());
        RateOfDifficulty rateOfDifficulty = modelMapper.map(saveReq ,RateOfDifficulty.class);

        return rateOfDifficultyRepository.add(rateOfDifficulty);
    }
    @Transactional
    @Override
    public RateOfDifficulty update(RateOfDifficultyReq saveReq) throws QuizException {
        RateOfDifficultyDto rateOfDifficultyDto = rateOfDifficultyRepository.findByID(
                saveReq.getiRateOfDifficultyPk());

        modelMapper.map(saveReq,rateOfDifficultyDto);
        RateOfDifficulty rateOfDifficulty = modelMapper.map(rateOfDifficultyDto,RateOfDifficulty.class);
        rateOfDifficulty.setiRateOfDifficultyPkEk(rateOfDifficulty.getiRateOfDifficultyPk());
        return rateOfDifficultyRepository.save(rateOfDifficulty);
    }
    @Transactional
    @Override
    public void delete(Integer iRateOfDifficultyPk) throws QuizException {
        RateOfDifficultyDto rateOfDifficultyDto = rateOfDifficultyRepository.findByID(
                iRateOfDifficultyPk);
        rateOfDifficultyDto.setiRateOfDifficultyPkEk(null);
        RateOfDifficulty rateOfDifficulty = modelMapper.map(rateOfDifficultyDto,RateOfDifficulty.class);
        rateOfDifficultyRepository.save(rateOfDifficulty);
    }
}
