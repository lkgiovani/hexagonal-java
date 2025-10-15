package hexagonal.infrastructure.db.repositories;

import hexagonal.infrastructure.db.entities.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EventJpaRepository extends CrudRepository<EventEntity, UUID> { 

}
