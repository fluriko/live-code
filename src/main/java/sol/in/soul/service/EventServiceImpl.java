package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sol.in.soul.dao.EventRepository;
import sol.in.soul.model.Event;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Optional<List<Event>> getAll() {
        return Optional.of(eventRepository.findAll());
    }
}
