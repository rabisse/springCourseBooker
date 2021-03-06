package com.example.springCourseBooker.Controllers;

import com.example.springCourseBooker.Models.Booking;
import com.example.springCourseBooker.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
        @RequestParam(required = false, name = "date") String bookingDate
    ){
        if(bookingDate != null) {
            return new ResponseEntity(bookingRepository.findByDate(bookingDate), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
