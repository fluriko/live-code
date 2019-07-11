package sol.in.soul.controller.model;

import sol.in.soul.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventExt {
    private Long id;
    private String name;
    private List<Long> userIds = new ArrayList<>();
    private Long organizerId;

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

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public static EventExt of(Event event) {
        EventExt result = new EventExt();
        result.setId(event.getId());
        result.setName(event.getName());
        List<Long> userIds = event.getUserToEvents().stream()
                .map(ute -> ute.getUser().getId())
                .collect(Collectors.toList());
        result.setUserIds(userIds);
        result.setOrganizerId(event.getOrganizer().getId());
        return result;
    }
}
