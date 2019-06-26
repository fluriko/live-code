package sol.in.soul.service;

import sol.in.soul.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<List<Event>> getAll();
}
