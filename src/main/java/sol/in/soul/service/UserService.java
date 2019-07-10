package sol.in.soul.service;

import sol.in.soul.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<List<User>> getAll();

    Optional<User> create(User user);

    Optional<User> update(User user);

    Optional<User> getById(Long id);

    void delete(Long id);
}
