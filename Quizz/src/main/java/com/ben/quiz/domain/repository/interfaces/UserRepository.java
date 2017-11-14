package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.SeiUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository {
//    SeiUser findSeiuserByUseridAndPassword(String username, String password) throws QuizException;

    SeiUser findSeiUserByUserId(String username) throws QuizException;

//    SeiUser findEmployeeSeiuserByUserId(String username) throws QuizException;

}
