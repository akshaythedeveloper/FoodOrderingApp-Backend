package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CustomerDao;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBusinessService {

    @Autowired
    private CustomerDao customerDao;

    public CustomerEntity signup(CustomerEntity customerEntity) {
        return customerDao.createCustomer(customerEntity);
    }
}
