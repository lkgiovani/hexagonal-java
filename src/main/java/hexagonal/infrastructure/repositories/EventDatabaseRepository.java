package hexagonal.infrastructure.repositories;

import hexagonal.application.domain.event.Event;
import hexagonal.application.domain.event.EventId;
import hexagonal.application.repositories.EventRepository;
import hexagonal.infrastructure.db.entities.EventEntity;
import hexagonal.infrastructure.db.repositories.EventDbRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

// Interface Adapter
@Component
public class EventDatabaseRepository implements EventRepository {

    private final EventDbRepository eventDbRepository;

    public EventDatabaseRepository(final EventDbRepository EventJpaRepository) {
        this.eventDbRepository = Objects.requireNonNull(EventJpaRepository);
    }

    @Override
    public Optional<Event> eventOfId(final EventId anId) {
        Objects.requireNonNull(anId, "id cannot be null");
        return this.eventDbRepository.findById(UUID.fromString(anId.value()))
                .map(EventEntity::toEvent);
    }

    @Override
    @Transactional
    public Event create(final Event Event) {
        return this.eventDbRepository.save(EventEntity.of(Event))
                .toEvent();
    }

    @Override
    @Transactional
    public Event update(Event Event) {
        return this.eventDbRepository.save(EventEntity.of(Event))
                .toEvent();
    }

    @Override
    public void deleteAll() {
        this.eventDbRepository.deleteAll();
    }
}
