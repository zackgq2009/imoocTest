package com.tsingkuo.tickets;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by johnnykuo on 2017/10/31.
 */
public class Tickets {
    private String ticketId;
    private Long ticketTime;
    private Calendar ticketDay;
    private double ticketPrice;
    private long ticketCount;

    public Tickets() {
    }

    public Tickets(String ticketId, Long ticketTime, Calendar ticketDay, double ticketPrice, long ticketCount) {
        this.ticketId = ticketId;
        this.ticketTime = ticketTime;
        this.ticketDay = ticketDay;
        this.ticketPrice = ticketPrice;
        this.ticketCount = ticketCount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Long ticketTime) {
        this.ticketTime = ticketTime;
    }

    public Calendar getTicketDay() {
        return ticketDay;
    }

    public void setTicketDay(Calendar ticketDay) {
        this.ticketDay = ticketDay;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(long ticketCount) {
        this.ticketCount = ticketCount;
    }
}
