package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.SequenceConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RoomInformationReq;
import com.ben.quiz.domain.dto.result.RoomInformDto;
import com.ben.quiz.domain.model.ExaminationRoom;
import com.ben.quiz.domain.repository.interfaces.RoomInformRepository;
import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import com.ben.quiz.service.interfaces.RoomInformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("room")
public class RoomInformServiceImpl implements RoomInformService{

    private final RoomInformRepository roomInformRepository ;
    private final UtilRepository utilRepository ;
    private final ModelMapper modelMapper ;
    @Autowired
    public RoomInformServiceImpl(RoomInformRepository roomInformRepository,
                                 UtilRepository utilRepository,
                                 ModelMapper modelMapper) {
        this.roomInformRepository = roomInformRepository;
        this.utilRepository = utilRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RoomInformDto> search(RoomInformationReq searchReq, PagingReq pagingReq) throws QuizException {
        return roomInformRepository.search(searchReq,pagingReq);
    }

    @Override
    public long count(RoomInformationReq searchReq) throws QuizException {
        return roomInformRepository.count(searchReq);
    }

    @Override
    public RoomInformDto findByID(Integer iExaminationRoomPk) throws QuizException {
        return modelMapper.map(roomInformRepository.findByID(iExaminationRoomPk),RoomInformDto.class);
    }
    @Transactional(readOnly = true)
    @Override
    public ExaminationRoom create(RoomInformationReq saveReq) throws QuizException {
        saveReq.setiExaminationRoomPk(
                utilRepository.findSequenceNextval(SequenceConst.EXAMINATION_ROOM_SEQ).intValue());
        saveReq.setiExaminationRoomPkEk(saveReq.getiExaminationRoomPk());
        ExaminationRoom examinationRoom = modelMapper.map(saveReq ,ExaminationRoom.class);
        return roomInformRepository.add(examinationRoom);
    }
    @Transactional(readOnly = true)
    @Override
    public ExaminationRoom update(RoomInformationReq saveReq) throws QuizException {
        ExaminationRoom examinationRoom = roomInformRepository.findByID(
                saveReq.getiExaminationRoomPk());

        modelMapper.map(saveReq,examinationRoom);
        examinationRoom.setiExaminationRoomPkEk(examinationRoom.getiExaminationRoomPk());
        return roomInformRepository.save(examinationRoom);
    }
    @Transactional(readOnly = true)
    @Override
    public void delete(Integer iExaminationRoomPk) throws QuizException {
        ExaminationRoom examinationRoom = roomInformRepository.findByID(
                iExaminationRoomPk);
        examinationRoom.setiExaminationRoomPkEk(null);
        roomInformRepository.save(examinationRoom);
    }
}
