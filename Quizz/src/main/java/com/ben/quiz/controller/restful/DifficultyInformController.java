package com.ben.quiz.controller.restful;

import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.FacultyInformSearchReq;
import com.ben.quiz.domain.dto.request.FacultyInformationSaveReq;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RateOfDifficultyReq;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.dto.result.RateOfDifficultyDto;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.domain.model.RateOfDifficulty;
import com.ben.quiz.domain.repository.interfaces.RateOfDifficultyRepository;
import com.ben.quiz.service.interfaces.RateOfDifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/difficulty")
public class DifficultyInformController extends BaseControllerRestful {

    @Autowired
    private RateOfDifficultyService rateOfDifficultyService;

    @GetMapping("/search")
    public List<RateOfDifficulty> search(@Valid RateOfDifficultyReq req,
                                         PagingReq pagingReq) throws QuizException {
        return rateOfDifficultyService.search(req, pagingReq);
    }
    @GetMapping("/count")
    public long count(RateOfDifficultyReq req) throws QuizException{
        return rateOfDifficultyService.count(req);
    }
    @GetMapping("/find/ID{iRateOfDifficultyPk}")
    public RateOfDifficulty findByID(@PathVariable("iRateOfDifficultyPk") Integer iRateOfDifficultyPk)throws QuizException{
        return rateOfDifficultyService.findByID(iRateOfDifficultyPk);
    }
    @PostMapping("/create")
    public RateOfDifficulty create(@RequestBody @Valid RateOfDifficultyReq saveReq) throws QuizException {
        return rateOfDifficultyService.create(saveReq);
    }

    @PostMapping("/update")
    public RateOfDifficulty update(@RequestBody @Valid RateOfDifficultyReq saveReq) throws QuizException {
        return rateOfDifficultyService.update(saveReq);
    }

    @DeleteMapping("/delete/{iRateOfDifficultyPk}")
    public void delete(@PathVariable("iRateOfDifficultyPk") Integer iRateOfDifficultyPk) throws QuizException {
        rateOfDifficultyService.delete(iRateOfDifficultyPk);
    }

}
