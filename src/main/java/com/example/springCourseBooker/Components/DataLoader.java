package com.example.springCourseBooker.Components;

import com.apple.eawt.Application;
import com.example.springCourseBooker.Models.Booking;
import com.example.springCourseBooker.Models.Course;
import com.example.springCourseBooker.Models.Customer;
import com.example.springCourseBooker.Repositories.BookingRepository;
import com.example.springCourseBooker.Repositories.CourseRepository;
import com.example.springCourseBooker.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){
        Customer David = new Customer("David", "Kingussie", 24);
        customerRepository.save(David);

        Customer Alex = new Customer("Alex", "Glasgow", 24);
        customerRepository.save(Alex);

        Course Java = new Course("Java101", "Glasgow", 8);
        courseRepository.save(Java);

        Course Python = new Course("Python101", "Kingussie", 5);
        courseRepository.save(Python);

        Booking booking1 = new Booking("1/1/2021", Java, Alex);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("12/1/2021", Python, David);
        bookingRepository.save(booking2);
    }
}
