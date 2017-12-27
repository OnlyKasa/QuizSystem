package com.ben.quiz.controller.restful;

import com.ben.quiz.controller.base.BaseControllerRestful;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RoomInformationReq;
import com.ben.quiz.domain.dto.result.FacultyInformDto;
import com.ben.quiz.domain.dto.result.RoomInformDto;
import com.ben.quiz.domain.model.ExaminationRoom;
import com.ben.quiz.domain.model.FacultyInformation;
import com.ben.quiz.service.interfaces.RoomInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomInformController extends BaseControllerRestful {

    @Autowired
    RoomInformService roomInformService;

    @GetMapping("/search")
    public List<RoomInformDto> search(@Valid RoomInformationReq roomInformationReq,
                                      PagingReq pagingReq) throws QuizException {
        return roomInformService.search(roomInformationReq, pagingReq);
    }
    @GetMapping("/count")
    public long count(@Valid RoomInformationReq roomInformationReq) throws QuizException{
        return roomInformService.count(roomInformationReq);
    }
    @GetMapping("/find/ID{iExaminationRoomPk}")
    public RoomInformDto findByID(@PathVariable("iExaminationRoomPk") Integer iExaminationRoomPk)throws QuizException{
        return roomInformService.findByID(iExaminationRoomPk);
    }
    @PostMapping("/create")
    public ExaminationRoom create(@RequestBody @Valid RoomInformationReq saveReq) throws QuizException {
        return roomInformService.create(saveReq);
    }

    @PostMapping("/update")
    public ExaminationRoom update(@RequestBody @Valid RoomInformationReq saveReq) throws QuizException {
        return roomInformService.update(saveReq);
    }

    @DeleteMapping("/delete/{iExaminationRoomPk}")
    public void delete(@PathVariable("iExaminationRoomPk") Integer iExaminationRoomPk) throws QuizException {
        roomInformService.delete(iExaminationRoomPk);
    }
}
