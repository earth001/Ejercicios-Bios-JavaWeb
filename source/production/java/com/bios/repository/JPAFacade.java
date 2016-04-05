
package com.bios.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;


public abstract class JPAFacade<T> {

    private Class<T> entityClass;
    
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected abstract EntityManager getEntityManager();
    public void create(T entity){
        getEntityManager().persist(entity);
    }
    public void update(T entity){
        getEntityManager().merge(entity);
    }
    public void remove(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    public T find(Object id){
        return getEntityManager().find(entityClass, id);
    }
    public List<T> findAll(){
        CriteriaQuery criteriaQuery=
                getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
}

