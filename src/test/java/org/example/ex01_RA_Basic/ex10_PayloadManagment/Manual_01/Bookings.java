package org.example.ex01_RA_Basic.ex10_PayloadManagment.Manual_01;

public class Bookings {
    private String firstname;
    private String lastname;
    private  Integer totalPrice;
    private Boolean depositpaid;
    private String additionalneeds;
    private  String BookingDates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public String getBookingDates() {
        return BookingDates;
    }

    public void setBookingDates(String bookingDates) {
        BookingDates = bookingDates;
    }
}
