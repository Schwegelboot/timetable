package com.dhbw.timetable.backend;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.dhbw.timetable.business.dto.Timeslot;

import reactor.core.publisher.Flux;

public interface SpringReactiveMongoTimeslotGateway extends ReactiveCrudRepository<Timeslot,String> {
    Flux<Timeslot> findByCourse(String course);
}
