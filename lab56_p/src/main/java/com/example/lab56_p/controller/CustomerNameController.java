package com.example.lab56_p.controller;

import java.util.List;
import com.example.lab56_p.entity.CustomerName;
import com.example.lab56_p.service.CustomerNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/customer-name")
public class CustomerNameController {

    @Autowired
    private CustomerNameService customernameservice;

    @GetMapping
    public List<CustomerName> getall() {
        return customernameservice.getAllcustnames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerName> getcustbuid(@PathVariable Long id) {
        return customernameservice.getcustById(id)
                .map(cname -> new ResponseEntity<>(cname, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CustomerName> displayall(@RequestBody CustomerName cname) {
        CustomerName cid = customernameservice.showallcust(cname);
        return new ResponseEntity<>(cid, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerName> displaybyid(@PathVariable Long id, @RequestBody CustomerName cnamedetail) {
        try {
            CustomerName newid = customernameservice.updatebyid(id, cnamedetail);
            return new ResponseEntity<>(newid, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Fixed delete mapping here
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebyid(@PathVariable Long id) {
        try {
            customernameservice.delebyId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
