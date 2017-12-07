package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RoomInformationReq;
import com.ben.quiz.domain.dto.result.RoomInformDto;
import com.ben.quiz.domain.model.ExaminationRoom;

import java.util.List;

public interface RoomInformRepository extends BaseRepository {
    List<RoomInformDto> search(RoomInformationReq searchReq,
                               PagingReq pagingReq) throws QuizException;
    long count(RoomInformationReq searchReq)throws QuizException;

    ExaminationRoom findByID(Integer iExaminationRoomPk)throws QuizException;

    ExaminationRoom create(RoomInformationReq saveReq) throws QuizException ;

    ExaminationRoom update(RoomInformationReq saveReq) throws QuizException ;

    void delete( Integer iExaminationRoomPk)throws QuizException ;
}
