package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.PropertiesUtil;
import com.ben.quiz.domain.model.Seiuser;
import com.ben.quiz.domain.model.Seiuser_;
import com.ben.quiz.domain.repository.interfaces.UserRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Repository("userRepository")
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository {

    @Override
    public Seiuser findSeiuserByUseridAndPassword(String userName, String passWord) throws QuizException {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Seiuser> criteriaQuery = builder.createQuery(Seiuser.class);
        final Root<Seiuser> SeiUserRoot = criteriaQuery.from(Seiuser.class);
        Predicate predicate = builder.and(builder.equal(SeiUserRoot.get(Seiuser_.userId), userName),
                builder.equal(SeiUserRoot.get("password"), passWord));

        criteriaQuery.select(SeiUserRoot).where(predicate);
        final TypedQuery<Seiuser> typedQuery = entityManager.createQuery(criteriaQuery);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            throw new QuizException(CodeConst.ErrorCode.ERR_099, PropertiesUtil.getMessage("USER.notExists"));
        }
    }


    @Override
    public Seiuser findSeiuserByUserid(String username) throws QuizException {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Seiuser> criteriaQuery = builder.createQuery(Seiuser.class);
        final Root<Seiuser> root = criteriaQuery.from(Seiuser.class);
        Predicate predicate = builder.and(
                builder.equal(root.get(Seiuser_.userId), username));
        criteriaQuery.select(root)
                .where(predicate);
        final TypedQuery<Seiuser> typedQuery = entityManager.createQuery(criteriaQuery);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            throw new QuizException(CodeConst.ErrorCode.ERR_099, CodeConst.Authentication.LOGIN_ERROR_USER_NOT_EXISTS);
        }

    }

    @Override
    public boolean isExistUserid(String username) throws QuizException {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        final Root<Seiuser> root = criteriaQuery.from(Seiuser.class);
        Predicate predicate = builder.and(
                builder.equal(root.get(Seiuser_.userId), username));
        criteriaQuery.select(builder.count(root.get(Seiuser_.userId)))
                .where(predicate);
        final TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getSingleResult() >0;
    }


}
