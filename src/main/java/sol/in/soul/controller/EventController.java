package sol.in.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sol.in.soul.controller.model.UserToEventExt;
import sol.in.soul.model.Event;
import sol.in.soul.model.Status;
import sol.in.soul.model.UserToEvent;
import sol.in.soul.service.EventService;
import sol.in.soul.service.UserToEventService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserToEventService userToEventService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Event> events = eventService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }

    @RequestMapping(value = "/editStatus", method = RequestMethod.GET)
    public ModelAndView editStatus(@RequestParam("ute_id") Long id, ModelAndView modelAndView) {
        List<String> statuses = Arrays.stream(Status.values()).map(Enum::toString).collect(toList());
        modelAndView.addObject("userToEventExt", userToEventService.getById(id).map(UserToEventExt::of));
        modelAndView.addObject("statuses", statuses);
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
}
