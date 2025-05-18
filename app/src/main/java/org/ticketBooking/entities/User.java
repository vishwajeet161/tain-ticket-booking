package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String password;
    private String hashPassword;
    private List<Ticket> ticketsBooked;
    private  String userId;

    public User(){
    }

    public User(String name, String password, String hashPassword, List<Ticket> ticketsBooked, String userId){
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.ticketsBooked = ticketsBooked;
        this.userId = userId;
    }


    //Getters
    public String getName(){
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Ticket> getTicketsBooked() {
        return this.ticketsBooked;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getHashedPassword() {
        return this.hashPassword;
    }

    public void printTickets(){
        for (Ticket ticket : this.ticketsBooked) {
            System.out.println(ticket.getTicketInfo());
        }
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
