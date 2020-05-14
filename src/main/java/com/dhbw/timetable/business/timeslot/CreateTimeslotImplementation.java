package com.dhbw.timetable.business.timeslot;

import org.springframework.stereotype.Service;

import com.dhbw.timetable.backend.SpringReactiveMongoTimeslotGateway;
import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.CreateTimeslotMessage;
import com.dhbw.timetable.web.requestDto.CreateTimeslotRequest;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateTimeslotImplementation implements CreateTimeslot{

    @NonNull
    SpringReactiveMongoTimeslotGateway timeslotGateway;

    @Override public Mono<Timeslot> perform(CreateTimeslotRequest request) {
        return timeslotGateway.save(mapRequestMessageToEntity(request.getMessage()));
    }

    private Timeslot mapRequestMessageToEntity(CreateTimeslotMessage message) {
        return Timeslot.builder()
                .course(message.getCourse())
                .startTime(message.getStartTime())
                .isActive(message.isActive())
                .endTime(message.getEndTime())
                .build();
    }
}