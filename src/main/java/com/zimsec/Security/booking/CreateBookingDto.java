package com.zimsec.Security.booking;

public record CreateBookingDto(
        String client_Name,
        int client_number,
        String activity,
        String email,
        String booking_date
) {}
