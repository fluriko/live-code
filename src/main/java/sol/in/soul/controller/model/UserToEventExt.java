package sol.in.soul.controller.model;

import sol.in.soul.model.UserToEvent;
import java.util.List;
import java.util.stream.Collectors;

public class UserToEventExt {
    private Long id;
    private Long userId;
    private Long eventId;
    private String userStatus;

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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public static UserToEventExt of(UserToEvent ute) {
        UserToEventExt result = new UserToEventExt();
        result.setId(ute.getId());
        result.setUserId(ute.getUser().getId());
        result.setEventId(ute.getEvent().getId());
        result.setUserStatus(ute.getUserStatus().toString());
        return result;
    }

    public static List<UserToEventExt> of(List<UserToEvent> ute) {
        return ute.stream()
                .map(UserToEventExt::of)
                .collect(Collectors.toList());
    }
}
