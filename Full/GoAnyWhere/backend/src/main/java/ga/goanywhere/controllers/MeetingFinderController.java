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

    @GetMapping("/meeting")
    public @ResponseBody MeetingEntity meeting(@RequestParam Long id){
        return meetingFinder.findMeetingById(id);
    }

    @GetMapping("/meeting/user")
    public @ResponseBody List<MeetingEntity> meetingsByUser(@RequestParam Long id) {
        return meetingFinder.findMeetingsByUser(id);
    }

    @GetMapping("meeting/creator")
    public @ResponseBody List<MeetingEntity> meetingsByCreator(@RequestParam Long id){
        return meetingFinder.findMeetingsCreatedByUser(id);
    }

    @GetMapping("meeting/category")
    public @ResponseBody List<MeetingEntity> meetingsByCategory(@RequestParam Long id){
        return meetingFinder.findMeetingsByCategory(id);
    }

    @GetMapping("meeting/locality")
    public @ResponseBody List<MeetingEntity> meetingsByLocality(@RequestParam String locality){
        return meetingFinder.findMeetingsByLocality(locality);
    }

    @GetMapping("meeting/actual")
    public @ResponseBody List<MeetingEntity> meetingsByActuality(@RequestParam Long id){
        return meetingFinder.findActualMeetingsForUser(id);
    }

}
