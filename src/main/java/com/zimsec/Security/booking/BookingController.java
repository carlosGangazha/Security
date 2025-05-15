package com.zimsec.Security.booking;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingRepository bookingRepository;

    public BookingController(BookingService bookingService, BookingRepository bookingRepository){
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }

    @PostMapping("/create-booking")
    public String create_booking(@RequestBody CreateBookingDto createBookingDto){
        return  bookingService.createBooking(createBookingDto);
    }
    @GetMapping("/get-bookings")
    public ResponseEntity<List<BookingResponseDto>> get_all_bookings(){
        List<BookingModel> my_bookings = bookingRepository.findAll();

        List<BookingResponseDto> responseDto  = my_bookings.stream().map(
                booking -> new BookingResponseDto(
                        booking.getCustomer_name(),
                        booking.getPax_number(),
                        booking.getBooking_date(),
                        booking.getPayment_status()
                )
        ).toList();
        return ResponseEntity.ok(responseDto);
    }
}
