package com.ben.quiz.domain.repository.interfaces;

import java.math.BigInteger;

/**
 * Created by QuangNV
 * on 11/7/2017.
 */
public interface UtilRepository extends BaseRepository {
    BigInteger findSequenceNextval(String sequenceName);
}

