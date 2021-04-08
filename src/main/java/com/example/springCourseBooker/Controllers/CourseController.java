package com.example.springCourseBooker.Controllers;

import com.example.springCourseBooker.Models.Course;
import com.example.springCourseBooker.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllBookings(
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customer_name") String customerName
    ){
        if(rating != null) {
            return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if(customerName != null) {
            return new ResponseEntity(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
