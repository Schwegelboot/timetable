package com.dhbw.timetable.business.timeslot;

import org.springframework.stereotype.Service;

import com.dhbw.timetable.backend.SpringReactiveMongoTimeslotGateway;
import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.GetTimeslotRequest;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class GetTimeslotViaCourseImplementation implements GetTimeSlotViaCourse{

    @NonNull
    SpringReactiveMongoTimeslotGateway timeslotGateway;

    @Override public Mono<Timeslot> perform(GetTimeslotRequest request) {
        return timeslotGateway.findByCourse(request.getCourse())
                .filter(timeslot -> timeslot.isActive())
                .next();
    }
}