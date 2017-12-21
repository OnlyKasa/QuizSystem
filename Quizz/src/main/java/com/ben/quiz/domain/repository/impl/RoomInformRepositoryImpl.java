package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.SQLUtil;
import com.ben.quiz.domain.dto.request.PagingReq;
import com.ben.quiz.domain.dto.request.RoomInformationReq;
import com.ben.quiz.domain.dto.result.RoomInformDto;
import com.ben.quiz.domain.model.ExaminationRoom;
import com.ben.quiz.domain.model.ExaminationRoom_;
import com.ben.quiz.domain.repository.interfaces.RoomInformRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("roomRepository")
public class RoomInformRepositoryImpl extends BaseRepositoryImpl implements RoomInformRepository {

    @Override
    public List<RoomInformDto> search(RoomInformationReq searchReq, PagingReq pagingReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ExaminationRoom> criteriaQuery = criteriaBuilder.createQuery(ExaminationRoom.class);
        final Root<ExaminationRoom> entityRoot = criteriaQuery.from(ExaminationRoom.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(entityRoot)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<ExaminationRoom> query = entityManager.createQuery(criteriaQuery);
        if (pagingReq.getPage() > 0) {
            query.setFirstResult((pagingReq.getPage() - 1) * pagingReq.getRowPerPage());
            query.setMaxResults(pagingReq.getRowPerPage());
        }
        List<ExaminationRoom> examinationRooms = query.getResultList();
        return examinationRooms.stream()
                .map(this::convertToRoomInformDto)
                .collect(Collectors.toList());
    }
    private RoomInformDto convertToRoomInformDto(ExaminationRoom examinationRoom){
        return modelMapper.map(examinationRoom,RoomInformDto.class);
    }

    @Override
    public long count(RoomInformationReq searchReq) throws QuizException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<ExaminationRoom> entityRoot = criteriaQuery.from(ExaminationRoom.class);

        List<Predicate>  predicates = createPredicateForSearchAndCount(criteriaBuilder,entityRoot,searchReq);
        criteriaQuery.select(criteriaBuilder.count(entityRoot))
                .where(predicates.toArray(new Predicate[predicates.size()]));
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
    private List<Predicate> createPredicateForSearchAndCount(CriteriaBuilder criteriaBuilder,
                                                             Root<ExaminationRoom> entityRoot,
                                                             RoomInformationReq searchReq){
        List<Predicate>  predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNotNull(entityRoot.get(ExaminationRoom_.iExaminationRoomPkEk)));
        predicates.add(criteriaBuilder.like(
                criteriaBuilder.lower(entityRoot.get(ExaminationRoom_.strExaminationRoomName)),
                SQLUtil.AllLike(searchReq.getStrExaminationRoomName())));

        return predicates ;
    }
    @Override
    public ExaminationRoom findByID(Integer iExaminationRoomPk) throws QuizException {
        ExaminationRoom examinationRoom = findOne(ExaminationRoom.class,
                iExaminationRoomPk);
        if(examinationRoom.getiExaminationRoomPkEk() == null){
            throw  new QuizException(CodeConst.ErrorCode.Err_Deleted_Record, CodeConst.ErrorMess.Err_Deleted_Record);
        }
        return examinationRoom;
    }

    @Override
    public ExaminationRoom create(RoomInformationReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public ExaminationRoom update(RoomInformationReq saveReq) throws QuizException {
        return null;
    }

    @Override
    public void delete(Integer iExaminationRoomPk) throws QuizException {

    }
}
