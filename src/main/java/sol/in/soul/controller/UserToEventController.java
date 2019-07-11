package sol.in.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sol.in.soul.service.UserToEventService;

@Controller
public class UserToEventController {

    @Autowired
    private UserToEventService userToEventService;


}
