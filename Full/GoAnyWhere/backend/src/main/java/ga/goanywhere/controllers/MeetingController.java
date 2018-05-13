package ga.goanywhere.controllers;

import ga.goanywhere.entities.CategoryEntity;
import ga.goanywhere.entities.UserEntity;
import ga.goanywhere.model.MeetingManger;
import ga.goanywhere.model.MeetingMangerImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class MeetingController {
    private MeetingManger meetingManger = new MeetingMangerImpl();

    @PostMapping("/meeting")
    public @ResponseBody Id createMeeting(@RequestBody Meeting meeting) throws ParseException{
        return  new Id(meetingManger.createMeeting(meeting.getId(),meeting.getCreatorId(), meeting.getCategoryId(),
                meeting.getAddressId(), meeting.getName(), meeting.getStartTime(), meeting.getEndTime(),
                meeting.getDescription(), meeting.getMaxParticipants(), meeting.getMinAge(), meeting.getAttachment()));
    }

    @PostMapping("/meeting/apply")
    public @ResponseBody String applyMeeting(@RequestBody Apply apply){
        meetingManger.applyMeeting(apply.getUserId(), apply.getMeetingId(), apply.getPrivilege());
        return "Done";
    }

    @DeleteMapping("/meeting")
    public @ResponseBody String deleteMeeting(@RequestBody Delete delete){
        meetingManger.deleteMeeting(delete.getUserId(), delete.getMeetingId());
        return "Done";
    }

    @DeleteMapping("/meeting/exit")
    public @ResponseBody String exitMeeting(@RequestBody Exit exit){
        meetingManger.exitMeeting(exit.getUserId(), exit.getMeetingId());
        return "Done";
    }

    @GetMapping("/meeting/participants")
    public @ResponseBody List<UserEntity> getMeetingParticipants(@RequestParam Long Id){
        return meetingManger.getMeetingParticipants(Id);
    }

    @GetMapping("/categories")
    public @ResponseBody List<CategoryEntity> getCategories(){
        return meetingManger.getCategories();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Id {
        private Long id;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Meeting {
        private Long Id;
        private Long creatorId;
        private Long categoryId;
        private Long addressId;
        private String name;
        private String startTime;
        private String endTime;
        private String description;
        private Long maxParticipants;
        private Long minAge;
        private byte[] attachment;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Apply{
        private Long userId;
        private Long meetingId;
        private String privilege;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Delete{
        private Long userId;
        private Long meetingId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Exit{
        private Long userId;
        private Long meetingId;
    }

}
