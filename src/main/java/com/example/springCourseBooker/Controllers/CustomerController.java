package com.example.springCourseBooker.Controllers;

import com.example.springCourseBooker.Models.Customer;
import com.example.springCourseBooker.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, name = "course_name") String courseName,
            @RequestParam(required = false, name = "town_name") String town,
            @RequestParam(required = false, name = "age") Integer age
    ){
        if (age != null && town != null && courseName != null){
            List<Customer> foundCustomers = customerRepository.findByTownAndAgeGreaterThanAndBookingsCourseNameAllIgnoreCase(town, age, courseName);
            return new ResponseEntity(foundCustomers, HttpStatus.OK);
        }
        if (town != null && courseName != null){
            List<Customer> foundCustomers = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town,courseName);
            return new ResponseEntity(foundCustomers, HttpStatus.OK);
        }
        if(courseName != null) {
            return new ResponseEntity(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
