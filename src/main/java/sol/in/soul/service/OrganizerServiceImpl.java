package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sol.in.soul.dao.OrganizerRepository;
import sol.in.soul.model.Organizer;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizerServiceImpl implements OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    public Optional<Organizer> getById(Long id) {
        return organizerRepository.findById(id);
    }

    @Override
    public Optional<Organizer> create(Organizer organizer) {
        return Optional.ofNullable(organizerRepository.save(organizer));
    }

    @Override
    public Optional<Organizer> update(Organizer organizer) {
        return Optional.ofNullable(organizerRepository.save(organizer));
    }

    @Override
    public void deleteById(Long id) {
        organizerRepository.deleteById(id);
    }

    @Override
    public Optional<List<Organizer>> getAll() {
        return Optional.ofNullable(organizerRepository.findAll());
    }
}
