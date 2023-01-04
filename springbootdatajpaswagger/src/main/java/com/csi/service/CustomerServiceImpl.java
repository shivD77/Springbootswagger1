package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {
    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer saveData(Customer customer) {
        return customerDaoImpl.saveData(customer);
    }

    public Optional<Customer> getDatabyID(int custId) {
        return customerDaoImpl.getDatabyID(custId);

    }

    public List<Customer> getAlldata() {
        return customerDaoImpl.getAlldata();
    }

    public Customer updatedata(Customer customer){
    return customerDaoImpl.updatedata(customer);
    }

    public void deleteData(int custId) {
        customerDaoImpl.deleteData(custId);
    }
}


