package sol.in.soul.service;

import sol.in.soul.model.UserToEvent;
import java.util.Optional;

public interface UserToEventService {
    Optional<UserToEvent> getById(Long id);

    Optional<UserToEvent> update(UserToEvent userToEvent);
}
