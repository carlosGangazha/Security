package com.zimsec.Security.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    private String customer_name;
    private int pax_number;
    private String activity;
    private String customer_email;
    private String booking_date;
    private int payment_status;
    private double commission;

    public BookingModel(String customer_name, int pax_number, String activity, String customer_email, String booking_date, int payment_status, double commission) {
        this.customer_name = customer_name;
        this.pax_number = pax_number;
        this.activity = activity;
        this.customer_email = customer_email;
        this.booking_date = booking_date;
        this.payment_status = payment_status;
        this.commission = commission;
    }
    public String getCustomer_name() {
        return customer_name;
    }

    public int getPax_number() {
        return pax_number;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public int getPayment_status() {
        return payment_status;
    }
}
