package hexagonal.demo.infrastructure.repositories;


import hexagonal.demo.infrastructure.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
