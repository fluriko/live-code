package sol.in.soul.controller.model;

import sol.in.soul.model.Event;
import sol.in.soul.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class EventExt {
    private Long id;
    private String name;
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static EventExt of(Event event) {
        EventExt result = new EventExt();
        result.setId(event.getId());
        result.setName(event.getName());
        List<User> users = event.getUserToEvents().stream()
                .map(ute -> ute.getUser())
                .collect(Collectors.toList());
        result.setUsers(users);
        return result;
    }
}
