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

@Entity
@Table(name = "USERS_TO_EVENTS")
public class UserToEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "FK_EVENT_ID")
    private Event event;

    @Column(name = "USER_STATUS")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus = UserStatus.INVITED;

    public UserToEvent() {
    }

    public UserToEvent(User user, Event event) {
        this.user = user;
        this.event = event;
    }

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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public static UserToEvent of(UserToEventExt ute) {
        UserToEvent result = new UserToEvent();
        User user = new User();
        Event event = new Event();

        user.setId(ute.getUserId());
        event.setId(ute.getEventId());
        result.setUser(user);
        result.setEvent(event);
        result.setId(ute.getId());
        result.setUserStatus(UserStatus.valueOf(ute.getUserStatus()));
        return result;
    }
}
