package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.repository.interfaces.UtilRepository;
import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuangNV
 * on 11/10/2017.
 */
@Repository("utilRepository")
public class UtilRepositoryImpl extends BaseRepositoryImpl implements UtilRepository {

    @Override
    public BigInteger findSequenceNextval(String sequenceName) {
        Query query = entityManager.createNativeQuery("select nextval(?)");
        query.setParameter(1, sequenceName);
        BigInteger nextSeq = (BigInteger) query.getSingleResult();
        if((nextSeq.compareTo(BigInteger.valueOf(1000000L)))==-1){
            return nextSeq.add(BigInteger.valueOf(1000000L));
        }else {
            return nextSeq;
        }
    }

}
