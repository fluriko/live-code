package sol.in.soul.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import sol.in.soul.model.Organizer;
import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    @EntityGraph("User.userToEvents")
    List<Organizer> findAll();
}
