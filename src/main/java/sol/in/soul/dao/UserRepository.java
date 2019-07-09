package sol.in.soul.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import sol.in.soul.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph("User.userToEvents")
    List<User> findAll();
}
