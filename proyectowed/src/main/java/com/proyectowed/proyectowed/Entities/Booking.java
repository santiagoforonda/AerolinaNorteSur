package com.proyectowed.proyectowed.Entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bookings")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private BookingStatus status;

    @ManyToOne
@JoinColumn(name = "outboundflight")
private Flight outBoundFlight;
    @Column
    private String paymentToken;
    @Column
    private Boolean checkedIn;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column
    private String createdAt;

    @Column
    private String bookingReference;

    public Booking(User customer,Flight outBoundFlight){
        this.customer = customer;
        this.outBoundFlight=outBoundFlight;
    }


    public Booking UpdateWidth(Booking oldBooking) {
        return new Booking(this.id,oldBooking.getStatus(),oldBooking.getOutBoundFlight(),oldBooking.getPaymentToken(),oldBooking.getCheckedIn(),oldBooking.getCustomer(),oldBooking.getCreatedAt(),oldBooking.getBookingReference());
    }
}
