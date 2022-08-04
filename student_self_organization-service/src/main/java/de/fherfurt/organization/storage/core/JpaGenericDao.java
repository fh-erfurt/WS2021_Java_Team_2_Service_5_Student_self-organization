package de.fherfurt.organization.storage.core;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class JpaGenericDao<T extends AbstractDatabaseEntity> implements IGenericDao<T> {

    private final Class<T> persistentClass;
    private EntityManager entityManager;

    public JpaGenericDao( Class<T> type, EntityManager em ) {
        this.persistentClass = type;
        this.entityManager = em;
    }

    @Override
    public T findById(int id) {
        return getEntityManager().find( persistentClass, id );
    }

    @Override
    public Collection<T> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM " + getPersistentClass().getCanonicalName() + " e"
        );
        return (Collection<T>) query.getResultList();
    }

    @Override
    public boolean create(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist( entity );
        getEntityManager().getTransaction().commit();

        return true;
    }

    @Override
    public boolean createAll(Collection<T> newEntities) {
        getEntityManager().getTransaction().begin();
        for( T entry : newEntities ) {
            getEntityManager().persist( entry );
        }
        getEntityManager().getTransaction().commit();

        return true;
    }

    @Override
    public T update(T entity) {
        getEntityManager().getTransaction().begin();
        final T savedEntity = getEntityManager().merge( entity );
        getEntityManager().getTransaction().commit();

        return savedEntity;
    }

    @Override
    public boolean delete(int id) {
        T entity = this.findById( id );
        this.delete( entity );

        return true;
    }

    @Override
    public boolean delete(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove( entity );
        getEntityManager().getTransaction().commit();

        return true;
    }

    @Override
    public boolean delete(List<T> entities) {
        getEntityManager().getTransaction().begin();
        for( T entry : entities ) {
            getEntityManager().remove( entry );
        }
        getEntityManager().getTransaction().commit();

        return true;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
