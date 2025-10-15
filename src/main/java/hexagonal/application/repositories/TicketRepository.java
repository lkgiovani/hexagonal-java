package hexagonal.application.repositories;

import hexagonal.application.domain.event.ticket.Ticket;
import hexagonal.application.domain.event.ticket.TicketId;

import java.util.Optional;

public interface TicketRepository {

    Optional<Ticket> ticketOfId(TicketId anId);

    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    void deleteAll();
}
