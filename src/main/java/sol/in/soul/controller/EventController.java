package sol.in.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sol.in.soul.controller.model.EventExt;
import sol.in.soul.controller.model.UserToEventExt;
import sol.in.soul.model.Event;
import sol.in.soul.model.Status;
import sol.in.soul.model.User;
import sol.in.soul.model.UserToEvent;
import sol.in.soul.service.EventService;
import sol.in.soul.service.UserService;
import sol.in.soul.service.UserToEventService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserToEventService userToEventService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Event> events = eventService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }

    @RequestMapping(value = "/editStatus", method = RequestMethod.GET)
    public ModelAndView editStatus(@RequestParam("ute_id") Long id, ModelAndView modelAndView) {
//        List<String> statuses = Arrays.stream(Status.values()).map(Enum::toString).collect(toList());
        modelAndView.addObject("userToEventExt", userToEventService.getById(id).map(UserToEventExt::of));
//        modelAndView.addObject("statuses", statuses);
        modelAndView.setViewName("editStatus");
        return modelAndView;
    }

    @RequestMapping(value = "/editStatus", method = RequestMethod.POST)
    public ModelAndView editStatus(@ModelAttribute("userToEventExt") UserToEventExt userToEventExt, ModelAndView modelAndView) {
        userToEventService.update(UserToEvent.of(userToEventExt));
        List<Event> events = eventService.getAll()
                .orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        List<User> users = userService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("users", users);
        modelAndView.addObject("eventExt", new EventExt());
        modelAndView.setViewName("addEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute EventExt eventExt, ModelAndView modelAndView) {
        userToEventService.create(eventExt.getUsers(), Event.of(eventExt));
        List<Event> events = eventService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }

    @RequestMapping(value = "/editEvent", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("e_id") Long id, ModelAndView modelAndView) {
        Event event = eventService.getById(id).orElseGet(Event::new);
        List<User> users = userService.getAll().orElseGet(Collections::emptyList);
        List<User> usersInvited = event.getUserToEvents().stream()
                .map(ute -> ute.getUser())
                .collect(Collectors.toList());
        List<User> usersNotInvited = users.stream()
                .filter(u -> !usersInvited.contains(u))
                .collect(Collectors.toList());
        modelAndView.addObject("usersNotInvited", usersNotInvited);
        modelAndView.addObject("eventExt", EventExt.of(event));
        modelAndView.setViewName("editEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/editEvent", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute EventExt eventExt, ModelAndView modelAndView) {
        eventService.update(Event.of(eventExt));
        userToEventService.createWithExistingEvent(eventExt.getUsers(), Event.of(eventExt));
        List<Event> events = eventService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("e_id") Long id, ModelAndView modelAndView) {
        eventService.delete(id);
        List<Event> events = eventService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }
}
