/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

/**
 *
 * @author fer
 */
public class Ticket {
    
    private Integer ticket;
    
    public Ticket(){}
    public Ticket(Integer ticket){
    this.ticket = ticket;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }
    
    
}
