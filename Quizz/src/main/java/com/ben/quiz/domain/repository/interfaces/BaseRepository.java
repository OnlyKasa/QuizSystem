package com.ben.quiz.domain.repository.interfaces;


import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.model.BaseEntity;

import java.util.List;

/**
 * A repository that persist BaseEntities
 *
 * @author LaurentiuM
 * @version createdOn: 12/27/17
 */
public interface BaseRepository {
    /**
     * Find all BaseEntities entities.
     *
     * @param clazz the class type of BaseEnity
     * @param <T>   the class type of BaseEnity
     * @return A Collection of Greeting objects.
     */
    <T extends BaseEntity> List<T> findAll(Class<T> clazz);

    /**
     * Find a single BaseEntity entity by primary key identifier.
     *
     * @param clazz the class type of BaseEntity
     * @param id    A Integer primary key identifier.
     * @param <T>   the class type of BaseEnity
     * @return A Greeting or <code>null</code> if none found.
     */
    <T extends BaseEntity> T findOne(Class<T> clazz, Integer id) throws QuizException;

    /**
     * Persists a BaseEntity entity in the data store.
     *
     * @param baseEntity A BaseEntity object to be persisted.
     * @param <T>        the class type of BaseEnity
     * @return The persisted BaseEntity entity.
     */
    <T extends BaseEntity> T add(T baseEntity);

    /**
     * Updates a previously persisted BaseEntity entity in the data store.
     *
     * @param baseEntity A BaseEntity object to be updated.
     * @param <T>        the class type of BaseEnity
     * @return The updated BaseEntity entity.
     */
    <T extends BaseEntity> T save(T baseEntity);

    /**
     * Removes a previously persisted BaseEntity entity from the data store.
     *
     * @param id    A Integer primary key identifier.
     * @param <T>   the class type of BaseEnity
     * @param clazz Of the entity that is persisted
     */
    <T extends BaseEntity> void delete(Class<T> clazz, Integer id) throws QuizException;

}