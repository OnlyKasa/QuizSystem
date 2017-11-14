package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.SeiUser;
import com.ben.quiz.domain.model.SeiUser_;
import com.ben.quiz.domain.repository.interfaces.UserRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository {

//    @Override
//    public SeiUser findSeiUserByUseridAndPassword(String userName, String passWord) throws GoovalException {
//        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        final CriteriaQuery<SeiUser> criteriaQuery = builder.createQuery(SeiUser.class);
//        final Root<SeiUser> SeiUserRoot = criteriaQuery.from(SeiUser.class);
//        final Root<MEmployee> employeeRoot = criteriaQuery.from(MEmployee.class);
//        Predicate predicate = builder.and(builder.equal(SeiUserRoot.get(SeiUser_.userId), userName),
//                builder.equal(SeiUserRoot.get("password"), passWord),
//                builder.equal(SeiUserRoot.get(SeiUser_.iEmployeePk), employeeRoot.get(MEmployee_.iEmployeePk)),
//                builder.isNull(employeeRoot.get(MEmployee_.dtTosConfirm)));
//        criteriaQuery.select(SeiUserRoot).where(predicate);
//        final TypedQuery<SeiUser> typedQuery = entityManager.createQuery(criteriaQuery);
//        try {
//            return typedQuery.getSingleResult();
//        } catch (NoResultException ex) {
//            throw new GoovalException(CodeConst.ErrorCode.ERR_099, PropertiesUtil.getMessage(USER_NOT_EX));
//        }
//    }


    @Override
    public SeiUser findSeiUserByUserId(String username) throws QuizException {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<SeiUser> criteriaQuery = builder.createQuery(SeiUser.class);
        final Root<SeiUser> root = criteriaQuery.from(SeiUser.class);
        Predicate predicate = builder.and(
                builder.equal(root.get(SeiUser_.userId), username));
        criteriaQuery.select(root)
                .where(predicate);
        final TypedQuery<SeiUser> typedQuery = entityManager.createQuery(criteriaQuery);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            throw new QuizException(CodeConst.ErrorCode.ERR_099, CodeConst.Authentication.LOGIN_ERROR_USER_NOT_EXISTS);
        }

    }
//
//    @Override
//    public SeiUser findEmployeeSeiUserByUserId(String strUserId) throws GoovalException {
//        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        final CriteriaQuery<SeiUser> criteriaQuery = builder.createQuery(SeiUser.class);
//        final Root<SeiUser> root = criteriaQuery.from(SeiUser.class);
//        Predicate predicate = builder.and(
//                builder.isNotNull(root.get(SeiUser_.iEmployeePk)),
//                builder.equal(root.get(SeiUser_.userId), strUserId));
//        criteriaQuery.where(predicate)
//                .select(root);
//
//        final TypedQuery<SeiUser> typedQuery = entityManager.createQuery(criteriaQuery);
//        try {
//            return typedQuery.getSingleResult();
//        } catch (NoResultException ex) {
//            throw new GoovalException(CodeConst.ErrorCode.ERR_099, PropertiesUtil.getMessage(USER_NOT_EX));
//        }
//    }

}
