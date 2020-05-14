package com.dhbw.timetable.web.timeslot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.timetable.business.timeslot.GetTimeSlotViaCourse;
import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.GetTimeslotRequest;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class GetTimeslotController {

    @Autowired
    GetTimeSlotViaCourse getTimeSlotViaCourse;

    @GetMapping(path = "timeslot/get-single-via-course")
    public Mono<Timeslot> getSingleTimeslotViaCourse(@RequestParam String course){
        GetTimeslotRequest request = GetTimeslotRequest.builder()
                .course(course)
                .build();
        return getTimeSlotViaCourse.perform(request);
    }
}