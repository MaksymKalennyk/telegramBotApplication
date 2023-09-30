package com.example.telegrambotapplication.services;

import com.example.telegrambotapplication.models.Ticket;
import com.example.telegrambotapplication.repo.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id){
        Optional<Ticket> placeOptional = ticketRepository.findById(id);
        if (placeOptional.isPresent()) {
            return placeOptional.get();
        } else {
            throw new EntityNotFoundException("Data with this id  " + id + " not found");
        }
    }

    public Ticket saveTicket(Ticket ticket){
        System.out.println(ticket.getName() + ticket.getSurname() + ticket.getPlace());
        System.out.println(ticket);
        return ticketRepository.save(ticket);
    }

    @Transactional
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            Ticket existingTicket = ticketOptional.get();
            existingTicket.setSurname(updatedTicket.getSurname());
            existingTicket.setName(updatedTicket.getName());
            existingTicket.setPlace(updatedTicket.getPlace());

            return ticketRepository.save(existingTicket);
        } else {
            throw new EntityNotFoundException("Data with this id " + id + " not found");
        }
    }
}
