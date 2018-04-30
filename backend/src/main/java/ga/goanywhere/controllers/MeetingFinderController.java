package ga.goanywhere.controllers;

import ga.goanywhere.entities.MeetingEntity;
import ga.goanywhere.model.MeetingFinder;
import ga.goanywhere.model.MeetingFinderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MeetingFinderController {
    private MeetingFinder meetingFinder = new MeetingFinderImpl();

    @GetMapping("/meeting/user")
    private @ResponseBody List<MeetingEntity> meetings(@RequestParam Long id) {
        return meetingFinder.findMeetingByUser(id);
    }

}
