package hexagonal.demo.repositories;


import hexagonal.demo.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
