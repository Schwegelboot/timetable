package com.dhbw.timetable.business.lecture;

import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.GetTimeslotRequest;

import reactor.core.publisher.Flux;

public interface GetAllLecturesForCurrentTimeslot {
    Flux<Lecture> perform(GetTimeslotRequest request);
}