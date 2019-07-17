package sol.in.soul.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORGANIZERS")
@PrimaryKeyJoinColumn(name = "ORGANIZER_ID", referencedColumnName = "USER_ID")
public class Organizer extends User {

    @OneToMany(mappedBy = "organizer")
    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public static Organizer of(User user) {
        Organizer result = new Organizer();
        result.setId(user.getId());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setEmail(user.getEmail());
        result.setPassword(user.getPassword());
        result.setEvents(new ArrayList<>());
        return result;
    }
}

/*
Добавить организатора ивентов Organizer
- роль организатора должен выполнять User
 * это отдельная таблица со ссылкой на User и ссылкой на Event соответственно.
 * один человек может быть как участник так и организатор
 * можно использовать связь One-to-One c User и One-toMany с Event
- организатор - это тот кто создает ивент
 * создать новую страницу .jsp для создания ивентов и приглашения на него участников.
 */
