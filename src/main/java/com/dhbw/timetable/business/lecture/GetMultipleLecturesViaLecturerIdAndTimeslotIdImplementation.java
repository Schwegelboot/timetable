package com.dhbw.timetable.business.lecture;

import org.springframework.stereotype.Service;

import com.dhbw.timetable.backend.SpringReactiveMongoLectureGateway;
import com.dhbw.timetable.backend.SpringReactiveMongoTimeslotGateway;
import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.GetLectureRequest;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetMultipleLecturesViaLecturerIdAndTimeslotIdImplementation implements GetMultipleLecturesViaLecturerIdAndTimeslotId {

    @NonNull
    SpringReactiveMongoLectureGateway lectureGateway;

    @NonNull SpringReactiveMongoTimeslotGateway timeslotGateway;

    @Override public Flux<Lecture> perform(GetLectureRequest request) {

        return lectureGateway.findByLecturerID(request.getLecturerID())
                .filter(lecture-> isLectureInCurrentTimeslot(request.getTimeslotID(), lecture));
    }

    private boolean isLectureInCurrentTimeslot(String timeslotID, Lecture lecture) {
        return lecture.getTimeslotID().equalsIgnoreCase(timeslotID);
    }
}