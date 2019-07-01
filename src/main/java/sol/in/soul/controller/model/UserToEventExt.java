package sol.in.soul.controller.model;

import sol.in.soul.model.Event;
import sol.in.soul.model.Status;
import sol.in.soul.model.User;
import sol.in.soul.model.UserToEvent;

public class UserToEventExt {
    private Long id;
    private Long userId;
    private Long eventId;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        result.setStatus(Status.valueOf(ute.getStatus()));
        return result;
    }
}
