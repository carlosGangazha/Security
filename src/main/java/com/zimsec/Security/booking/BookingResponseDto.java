package com.zimsec.Security.booking;

public record BookingResponseDto(
         String customer_name,
         int pax_number,
         String booking_date,
         int payment_status
) {
}
