package sol.in.soul.model;

import sol.in.soul.controller.model.EventExt;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "EVENT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<UserToEvent> userToEvents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "FK_ORGANIZER_ID")
    private Organizer organizer;

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

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void addUsers(List<UserToEvent> userToEvents) {
        this.userToEvents.addAll(userToEvents);
    }

    public static Event of(EventExt eventExt) {
        Event result = new Event();
        result.setId(eventExt.getId());
        result.setName(eventExt.getName());

        Organizer organizer = new Organizer();
        organizer.setId(eventExt.getOrganizerId());
        result.setOrganizer(organizer);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(name, event.name) &&
                Objects.equals(organizer, event.organizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, organizer);
    }
}
