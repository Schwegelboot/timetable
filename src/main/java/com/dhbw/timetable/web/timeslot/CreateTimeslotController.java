package com.dhbw.timetable.web.timeslot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.timetable.business.timeslot.CreateTimeslot;
import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.CreateTimeslotMessage;
import com.dhbw.timetable.web.requestDto.CreateTimeslotRequest;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class CreateTimeslotController {

    @Autowired
    CreateTimeslot createTimeslot;

    @PostMapping(path = "timeslot/create")
    public Mono<Timeslot> createLecture(@RequestBody CreateTimeslotMessage message){
        CreateTimeslotRequest request = CreateTimeslotRequest.builder()
                .message(message)
                .build();
        return createTimeslot.perform(request);
    }
}