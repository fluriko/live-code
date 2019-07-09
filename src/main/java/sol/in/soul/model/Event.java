package sol.in.soul.model;

import sol.in.soul.controller.model.EventExt;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import java.util.stream.Collectors;

@Entity
@Table(name = "EVENTS")
@NamedEntityGraph(name = "Event.userToEvents", attributeNodes = @NamedAttributeNode("userToEvents"))
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
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

    public static Event of(EventExt eventExt) {
        Event result = new Event();
        result.setId(eventExt.getId());
        result.setName(eventExt.getName());
        List<UserToEvent> userToEvents = eventExt.getUsers().stream()
                .map(u -> {
                    UserToEvent ute = new UserToEvent();
                    ute.setUser(u);
                    ute.setEvent(result);
                    return ute;
                }).collect(Collectors.toList());
        result.setUserToEvents(userToEvents);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(name, event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
