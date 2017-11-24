package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.repository.interfaces.TeacherRepository;
import org.springframework.stereotype.Repository;

@Repository("teacherRepository")
public class TeacherRepositoryImpl extends BaseRepositoryImpl implements TeacherRepository  {

    @Override
    public long count() {
        return 0;
    }
}
