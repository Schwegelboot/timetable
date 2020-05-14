package com.dhbw.timetable.business.timeslot;

import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.GetTimeslotRequest;

import reactor.core.publisher.Mono;

public interface GetTimeSlotViaCourse {
    Mono<Timeslot> perform(GetTimeslotRequest request);
}