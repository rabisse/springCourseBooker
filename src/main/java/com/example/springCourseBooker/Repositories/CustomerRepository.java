package com.example.springCourseBooker.Repositories;

import com.example.springCourseBooker.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    // Get all customers in a given town for a given course
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String name);

    // Get all customers over a certain age in a given town for a given course
    List<Customer> findByTownAndAgeGreaterThanAndBookingsCourseNameAllIgnoreCase(String town, int age, String name);

}
