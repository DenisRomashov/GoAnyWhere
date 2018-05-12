package ga.goanywhere.controllers;

import ga.goanywhere.entities.MeetingEntity;
import ga.goanywhere.model.MeetingFinder;
import ga.goanywhere.model.MeetingFinderImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("meeting/actual")
    public @ResponseBody List<MeetingEntity> meetingsByActuality(@RequestParam Long id){
        return meetingFinder.findActualMeetingsForUser(id);
    }

    @PostMapping("meeting/search")
    public @ResponseBody List<MeetingEntity> searchMeetings(@RequestBody Search search) {
        return meetingFinder.meetingSearch(search.getSearcherId(), search.getCategoryId(), search.getLocality());
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Search {
        private Long searcherId;
        private Long categoryId;
        private String locality;
    }

}
