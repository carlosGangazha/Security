package com.zimsec.Security.booking;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    String createBooking(CreateBookingDto createBooking){
        try {
            var booking = new BookingModel(
                    createBooking.client_Name(),
                    createBooking.client_number(),
                    createBooking.activity(),
                    createBooking.email(),
                    createBooking.booking_date(),
                    0,0.0
            );
            bookingRepository.save(booking);
            return "Booking created successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
