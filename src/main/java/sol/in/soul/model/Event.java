package sol.in.soul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EVENTS")
@NamedEntityGraph(name = "Event.userToEvents", attributeNodes = @NamedAttributeNode("userToEvents"))
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "event")
    private List<UserToEvent> userToEvents = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserToEvent> getUserToEvents() {
        return userToEvents;
    }

    public void setUserToEvents(List<UserToEvent> userToEvents) {
        this.userToEvents = userToEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(name, event.name) &&
                Objects.equals(userToEvents, event.userToEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userToEvents);
    }
}
