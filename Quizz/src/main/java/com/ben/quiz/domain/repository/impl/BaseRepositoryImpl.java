package com.ben.quiz.domain.repository.impl;

import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.BaseEntity;
import com.ben.quiz.domain.repository.interfaces.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * A repository that persist BaseEntities
 *
 * @author QuangNV
 * @version createdOn: 12/10/17
 */
public class BaseRepositoryImpl implements BaseRepository {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ModelMapper modelMapper ;


    /**
     * Find all BaseEntities entities.
     *
     * @param <T> the class type of BaseEnity
     * @return A Collection of BaseEnity objects.
     */
    public <T extends BaseEntity> List<T> findAll(Class<T> clazz) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteria = criteriaBuilder.createQuery(clazz);

        final Root<T> root = criteria.from(clazz);
        criteria.select(root);

        final TypedQuery<T> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    /**
     * Count all BaseEntities entities.
     *
     * @param <T> the class type of BaseEnity
     * @return A total number of BaseEnity objects.
     */
    public <T extends BaseEntity> Long countAll(Class<T> clazz) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(clazz);

        Expression<Long> count = criteriaBuilder.count(root);
        criteriaQuery.select(count);
        final TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    /**
     * Find a single BaseEntity entity by primary key identifier.
     *
     * @param id  A Integer primary key identifier.
     * @param <T> the class type of BaseEnity
     * @return A Greeting or <code>null</code> if none found.
     */
    public <T extends BaseEntity> T findOne(Class<T> clazz, Integer id) throws QuizException {
        T result = entityManager.find(clazz, id);
        if (result == null) {
            throw new QuizException(1, "Finding by id " + id + " is not found");
        } else {
            return result;
        }
    }

    /**
     * Persists a BaseEntity entity in the data store.
     *
     * @param baseEntity A BaseEntity object to be persisted.
     * @param <T>        the class type of BaseEnity
     * @return The persisted BaseEntity entity.
     */
    public <T extends BaseEntity> T add(T baseEntity) {
        return  entityManager.merge(baseEntity);
    }

    /**
     * Updates a previously persisted BaseEntity entity in the data store.
     *
     * @param baseEntity A BaseEntity object to be updated.
     * @param <T>        the class type of BaseEnity
     * @return The updated BaseEntity entity.
     */
    public <T extends BaseEntity> T save(T baseEntity) {
        return entityManager.merge(baseEntity);
    }

    /**
     * Removes a previously persisted BaseEntity entity from the data store.
     *
     * @param id    A Integer primary key identifier.
     * @param <T>   the class type of BaseEnity
     * @param clazz Of the entity that is persisted
     */
    public <T extends BaseEntity> void delete(Class<T> clazz, Integer id) throws QuizException {
        BaseEntity baseEntity = findOne(clazz, id);
        if (baseEntity != null) {
            if (!entityManager.contains(baseEntity))
                baseEntity = entityManager.merge(baseEntity);
            entityManager.remove(baseEntity);
        } else {
            throw new QuizException(1, "Not found object by Id" + id, null);
        }
    }

}
