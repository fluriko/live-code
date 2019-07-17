package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sol.in.soul.dao.EventRepository;
import sol.in.soul.dao.UserToEventRepository;
import sol.in.soul.model.Event;
import sol.in.soul.model.User;
import sol.in.soul.model.UserToEvent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserToEventServiceImpl implements UserToEventService {

    @Autowired
    private UserToEventRepository userToEventRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Optional<UserToEvent> getById(Long id) {
        return userToEventRepository.findById(id);
    }

    @Override
    public Optional<UserToEvent> update(UserToEvent userToEvent) {
        return Optional.of(userToEventRepository.save(userToEvent));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Optional<Event> create(List<User> users, Event event) {
        Event e = eventRepository.save(event);
        users.stream()
                .map(u -> new UserToEvent(u, e))
                .forEach(userToEventRepository::save);
        return Optional.of(e);
    }

    @Override
    public Optional<List<UserToEvent>> getAll() {
        return Optional.ofNullable(userToEventRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        userToEventRepository.deleteById(id);
    }

    @Override
    public Optional<UserToEvent> create(UserToEvent userToEvent) {
        return Optional.ofNullable(userToEventRepository.save(userToEvent));
    }
}
