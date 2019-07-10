package sol.in.soul.service;

import sol.in.soul.model.Organizer;
import java.util.List;
import java.util.Optional;

public interface OrganizerService {

    Optional<Organizer> getById(Long id);

    Optional<Organizer> create(Organizer organizer);

    Optional<Organizer> update(Organizer organizer);

    void deleteById(Long id);

    Optional<List<Organizer>> getAll();

}
