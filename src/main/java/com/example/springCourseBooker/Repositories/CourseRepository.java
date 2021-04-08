package com.example.springCourseBooker.Repositories;

import com.example.springCourseBooker.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(int rating);
    
    List<Course> findByBookingsCustomerName(String name);


}
