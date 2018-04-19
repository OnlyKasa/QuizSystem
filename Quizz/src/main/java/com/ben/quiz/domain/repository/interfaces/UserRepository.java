package com.ben.quiz.domain.repository.interfaces;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.Seiuser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository {
    Seiuser findSeiuserByUseridAndPassword(String username, String password) throws QuizException;

    Seiuser findSeiuserByUserid(String username) throws QuizException;

    Seiuser findSeiuserByiStudentPk(Integer iStudentInformationPk)throws QuizException;

    Seiuser findSeiuserByiTeacherPk(Integer iTeacherInformationPk)throws QuizException;

    boolean isExistUserid(String username) throws QuizException ;
}
