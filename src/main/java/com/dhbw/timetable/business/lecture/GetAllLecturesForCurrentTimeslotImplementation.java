package com.dhbw.timetable.business.lecture;

import org.springframework.stereotype.Service;

import com.dhbw.timetable.backend.SpringReactiveMongoLectureGateway;
import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.GetTimeslotRequest;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllLecturesForCurrentTimeslotImplementation implements GetAllLecturesForCurrentTimeslot {

    @NonNull
    SpringReactiveMongoLectureGateway lectureGateway;

    @Override public Flux<Lecture> perform(GetTimeslotRequest request) {
        return lectureGateway.findByTimeslotID(request.getTimeslotID());
    }
}