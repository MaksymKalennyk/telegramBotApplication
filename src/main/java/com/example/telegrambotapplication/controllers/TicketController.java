package com.example.telegrambotapplication.controllers;

import com.example.telegrambotapplication.models.Ticket;
import com.example.telegrambotapplication.services.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/find/all")
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/find/{id}")
    public Ticket findById(@PathVariable("id") Long id){
        return ticketService.findById(id);
    }

    @PostMapping("/add")
    public Ticket save(Ticket ticket){
        return ticketService.saveTicket(ticket);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id,Ticket updatedTicket) {
        try {
            Ticket updated = ticketService.updateTicket(id, updatedTicket);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
