package sol.in.soul.service;

import sol.in.soul.model.Event;
import sol.in.soul.model.User;
import sol.in.soul.model.UserToEvent;

import java.util.List;
import java.util.Optional;

public interface UserToEventService {
    Optional<UserToEvent> getById(Long id);

    Optional<UserToEvent> update(UserToEvent userToEvent);

    Optional<Event> create(List<User> users, Event event);

    Optional<List<UserToEvent>> getAll();

    void delete(Long id);

    Optional<UserToEvent> create(UserToEvent userToEvent);

}
