package com.dhbw.timetable.business.timeslot;

import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.CreateTimeslotRequest;

import reactor.core.publisher.Mono;

public interface CreateTimeslot {
    Mono<Timeslot> perform(CreateTimeslotRequest request);
}