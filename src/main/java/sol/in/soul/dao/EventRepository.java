package sol.in.soul.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import sol.in.soul.model.Event;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @EntityGraph("Event.userToEvents")
    List<Event> findAll();

    List<Event> getAllByOrganizer_Id(Long id);
}
