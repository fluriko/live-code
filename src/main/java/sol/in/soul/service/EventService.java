package sol.in.soul.service;

import sol.in.soul.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<List<Event>> getAll();

    Optional<Event> create(Event event);

    Optional<Event> getById(Long id);

    Optional<Event> update(Event event);

    void delete(Long id);
}
