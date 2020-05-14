package com.dhbw.timetable.backend;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.dhbw.timetable.business.dto.Lecture;

import reactor.core.publisher.Flux;

public interface SpringReactiveMongoLectureGateway extends ReactiveCrudRepository<Lecture,String> {
    Flux<Lecture> findByLecturerID(String lecturerId);
    Flux<Lecture> findByTimeslotID(String timeslotId);
}
