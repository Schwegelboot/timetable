package com.dhbw.timetable.web.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.timetable.business.lecture.GetAllLecturesForCurrentTimeslot;
import com.dhbw.timetable.business.lecture.GetMultipleLecturesViaLecturerIdAndTimeslotId;
import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.GetLectureRequest;
import com.dhbw.timetable.web.requestDto.GetTimeslotRequest;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
public class GetLectureController {
    @Autowired
    GetMultipleLecturesViaLecturerIdAndTimeslotId getMultipleLecturesViaLecturerIdAndTimeslotId;

    @Autowired
    GetAllLecturesForCurrentTimeslot getAllLecturesForCurrentTimeslot;


    @GetMapping(path = "lecture/get-multiple-via-lecturer-id-and-timeslot-id")
    public Flux<Lecture> getMultipleLecturesViaLecturerIDAndTimeslotID(@RequestParam String lecturerID, @RequestParam String timeslotID){
        GetLectureRequest request = GetLectureRequest.builder()
                .lecturerID(lecturerID)
                .timeslotID(timeslotID)
                .build();
        return getMultipleLecturesViaLecturerIdAndTimeslotId.perform(request);
    }

    @GetMapping(path = "lecture/get-multiple-via-timeslot")
    public Flux<Lecture> getAllLectureInTimeRange(@RequestParam String timeslotID){
        GetTimeslotRequest request = GetTimeslotRequest.builder()
                .timeslotID(timeslotID)
                .build();
       return getAllLecturesForCurrentTimeslot.perform(request);
    }
}