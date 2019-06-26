package sol.in.soul.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import sol.in.soul.model.Event;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @EntityGraph("Event.users")
    List<Event> findAll();
}
