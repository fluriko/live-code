package sol.in.soul.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Organizer extends User {

    public Event createEvent() {
        return new Event();
    }
}
