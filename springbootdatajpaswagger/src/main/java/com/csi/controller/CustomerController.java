package com.csi.controller;

import com.csi.exception.RecordNotfoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Optional<Customer>> getDatabyId(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.getDatabyID(custId));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List>getalldata(){
        return ResponseEntity.ok(customerServiceImpl.getAlldata());
    }
    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer>updatedata(@PathVariable int custId, @RequestBody Customer customer) throws RecordNotfoundException{
        Customer customer1= customerServiceImpl.getDatabyID(custId).orElseThrow(()-> new RecordNotfoundException("customer Record Does Not exist"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNUmber(customer.getCustContactNUmber());
        customer1.setCustDOB(customer.getCustDOB());
         return ResponseEntity.ok(customerServiceImpl.updatedata(customer1));
    }
    @DeleteMapping("/deletedatabyid/{custId}")
    public ResponseEntity<String>deletedatabyid(@PathVariable int custId){
        customerServiceImpl.deleteData(custId);
        return  ResponseEntity.ok("Data deleted syuccessfully");
    }

}
