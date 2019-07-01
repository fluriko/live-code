package sol.in.soul.model;

import sol.in.soul.controller.model.UserToEventExt;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "USERS_TO_EVENTS")
public class UserToEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_EVENT_ID")
    private Event event;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static UserToEventExt of(UserToEvent ute) {
        UserToEventExt result = new UserToEventExt();
        result.setId(ute.getId());
        result.setUserId(ute.getUser().getId());
        result.setEventId(ute.getEvent().getId());
        result.setStatus(ute.getStatus().toString());
        return result;
    }

    public static List<UserToEventExt> of(List<UserToEvent> ute) {
        return ute.stream()
                .map(UserToEvent::of)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserToEvent)) return false;
        UserToEvent that = (UserToEvent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(event.getId(), that.event.getId()) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user.getId(), event.getId(), status);
    }
}
