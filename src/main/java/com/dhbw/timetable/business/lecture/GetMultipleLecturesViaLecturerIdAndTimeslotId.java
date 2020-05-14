package com.dhbw.timetable.business.lecture;

import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.GetLectureRequest;

import reactor.core.publisher.Flux;

public interface GetMultipleLecturesViaLecturerIdAndTimeslotId {
    Flux<Lecture> perform(GetLectureRequest request);
}