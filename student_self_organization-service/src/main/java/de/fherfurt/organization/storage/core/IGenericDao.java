package de.fherfurt.organization.storage.core;

import java.util.Collection;
import java.util.List;

/**
 * This interface is the abstract layer between Daos and the Repositorys. It stores all generics.
 * @param <T> Generic type which extends AbstractDatabaseEntity
 */
public interface IGenericDao<T extends AbstractDatabaseEntity> {

    /**
     * finds an object of type T by id
     * @param id searched object id
     * @return found object of typ T
     */
    T findById( int id );

    /**
     * finds a collection of objects of type T
     * @return collection of objects
     */
    Collection<T> findAll();

    /**
     * add object to database
     * @param entity object to add
     * @return true is successful
     */
    boolean create( T entity );

    /**
     * add all objects from a collection to database
     * @param newEntities collection of objects
     * @return true if successful
     */
    boolean createAll( Collection<T> newEntities);

    /**
     * updates an object in the database
     * @param entity object to be updated
     * @return updated entity
     */
    T update( T entity );

    /**
     * deletes an object in the database by id
     * @param id id of searched object
     * @return true if successful
     */
    boolean delete( int id );

    /**
     * deletes an given object from the database
     * @param entity to be deleted
     * @return true if successful
     */
    boolean delete( T entity );

    /**
     * deletes an list of objects from the database
     * @param entities list of objects
     * @return true if successful
     */
    boolean delete( List<T> entities);
}
