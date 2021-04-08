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

        Customer Alex = new Customer("Alex", "Glasgow", 31);
        customerRepository.save(Alex);

        Customer Juan = new Customer("Jerry", "Glasgow", 44);
        customerRepository.save(Juan);

        Customer John = new Customer("Jim", "Glasgow", 45);
        customerRepository.save(John);

        Customer Harrison = new Customer("Harrison", "Kingussie", 45);
        customerRepository.save(Harrison);

        Course Java = new Course("Java101", "Glasgow", 8);
        courseRepository.save(Java);

        Course JavaScript = new Course("JavaScript101", "Glasgow", 8);
        courseRepository.save(JavaScript);

        Course Python = new Course("Python101", "Kingussie", 5);
        courseRepository.save(Python);

        Booking booking1 = new Booking("1/1/2021", Java, Alex);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("12/1/2021", Python, David);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("13/1/2021", Java, Juan);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("15/1/2021", JavaScript, John);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("12/1/2021", Java, Harrison);
        bookingRepository.save(booking5);
    }
}
