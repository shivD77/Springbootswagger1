package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.Customerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl {
    @Autowired
    Customerrepo customerrepoImpl;
    public Customer saveData(Customer customer) {
        return customerrepoImpl.save(customer);
    }

    public Optional<Customer> getDatabyID(int custId) {
        return customerrepoImpl.findById(custId);
    }

    public List<Customer> getAlldata() {
        return customerrepoImpl.findAll();
    }

    public Customer updatedata(Customer customer) {
        return customerrepoImpl.save(customer);
    }

    public void deleteData(int custId) {
        customerrepoImpl.deleteById(custId);
    }
}
