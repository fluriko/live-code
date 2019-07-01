package sol.in.soul.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sol.in.soul.model.UserToEvent;

public interface UserToEventRepository extends JpaRepository<UserToEvent, Long> {
}
