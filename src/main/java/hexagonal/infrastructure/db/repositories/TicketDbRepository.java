package hexagonal.infrastructure.db.repositories;

import hexagonal.infrastructure.db.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TicketDbRepository extends CrudRepository<TicketEntity, UUID> {

}
