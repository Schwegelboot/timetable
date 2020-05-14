package com.dhbw.timetable.business.lecture;

import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.CreateLectureRequest;

import reactor.core.publisher.Mono;

public interface CreateLecture {
    Mono<Lecture> perform(CreateLectureRequest request);
}