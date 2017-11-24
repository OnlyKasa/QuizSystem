package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.repository.interfaces.StudentRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public class StudentRepositoryImpl extends BaseRepositoryImpl implements StudentRepository {
    @Override
    public long count() {
        return 0;
    }
}
