package sol.in.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sol.in.soul.model.Organizer;
import sol.in.soul.service.OrganizerService;
import java.util.Collections;
import java.util.List;

@Controller
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    private ModelAndView getAllFromDb() {
        ModelAndView modelAndView = new ModelAndView();
        List<Organizer> organizers = organizerService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("organizers", organizers);
        modelAndView.setViewName("organizers");
        return modelAndView;
    }

    @RequestMapping(value = "/organizers", method = RequestMethod.GET)
    public ModelAndView getAll() {
        return getAllFromDb();
    }

    @RequestMapping(value = "/organizer", method = RequestMethod.GET)
    public ModelAndView getById(@RequestParam("o_id") Long id, ModelAndView modelAndView) {
        Organizer organizer = organizerService.getById(id).orElseGet(Organizer::new);
        modelAndView.addObject("organizer", organizer);
        modelAndView.setViewName("organizer");
        return modelAndView;
    }

}
