package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sol.in.soul.dao.UserToEventRepository;
import sol.in.soul.model.UserToEvent;
import java.util.Optional;

@Service
public class UserToEventServiceImpl implements UserToEventService {

    @Autowired
    private UserToEventRepository userToEventRepository;

    @Override
    public Optional<UserToEvent> getById(Long id) {
        return userToEventRepository.findById(id);
    }

    @Override
    public Optional<UserToEvent> update(UserToEvent userToEvent) {
        return Optional.of(userToEventRepository.save(userToEvent));
    }
}
