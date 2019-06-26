package sol.in.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sol.in.soul.model.Event;
import sol.in.soul.service.EventService;
import java.util.Collections;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Event> events = eventService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("events", events);
        modelAndView.setViewName("events");
        return modelAndView;
    }
}
