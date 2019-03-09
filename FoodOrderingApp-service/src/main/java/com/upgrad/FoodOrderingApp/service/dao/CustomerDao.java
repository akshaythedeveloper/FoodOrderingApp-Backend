package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * CustomerDao class provides the database access for all the endpoints in user controller.
 */
@Repository
public class CustomerDao {

    //When a container of the application(be it a Java EE container or any other custom container like Spring) manages the lifecycle of the Entity Manager, the Entity Manager is said to be Container Managed. The most common way of acquiring a Container Managed EntityManager is to use @PersistenceContext annotation on an EntityManager attribute.
    @PersistenceContext
    private EntityManager entityManager;



    public CustomerEntity getCustomerByContactNumber(String contactNumber) {
        try {
            return entityManager.createNamedQuery("customerByContactNumber" , CustomerEntity.class).setParameter("contactNumber" , contactNumber).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }


    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
        return customerEntity;
    }
}
