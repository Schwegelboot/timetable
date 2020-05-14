package com.dhbw.timetable.business.lecture;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.stereotype.Service;

import com.dhbw.timetable.backend.SpringReactiveMongoLectureGateway;
import com.dhbw.timetable.backend.SpringReactiveMongoTimeslotGateway;
import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.business.dto.Timeslot;
import com.dhbw.timetable.web.requestDto.CreateLectureMessage;
import com.dhbw.timetable.web.requestDto.CreateLectureRequest;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateLectureImplementation implements CreateLecture {

    @NonNull
    SpringReactiveMongoLectureGateway lectureGateway;

    @NonNull
    SpringReactiveMongoTimeslotGateway timeslotGateway;

    @Override
    public Mono<Lecture> perform(CreateLectureRequest request) {
        return timeslotGateway.findByCourse(request.getMessage().getCourse())
                .filter(timeslot -> isLectureInCurrentTimeslot(timeslot, request.getMessage().getStartTime()))
                .next()
                .flatMap(currentTimeSlot -> lectureGateway.save(mapRequestMessageToEntity(request.getMessage(), currentTimeSlot.getId())));
    }

    private Lecture mapRequestMessageToEntity(CreateLectureMessage message , String timeslotID) {
        return Lecture.builder()
                .name(message.getName())
                .timeslotID(timeslotID)
                .lecturerID(message.getLecturerID())
                .course(message.getCourse())
                .location(message.getLocation())
                .duration(createDurationFromLectureTimeslot(message.getStartTime(), message.getEndTime()))
                .endTime(message.getEndTime())
                .startTime(message.getStartTime())
                .build();
    }

    private int createDurationFromLectureTimeslot(DateTime startTime, DateTime endTime) {
        return Minutes.minutesBetween(startTime, endTime).getMinutes();
    }

    private boolean isLectureInCurrentTimeslot(Timeslot timeslot, DateTime lectureDay) {
        return timeslot.isActive() && timeslot.getStartTime().isBefore(lectureDay) &&
                timeslot.getEndTime().isAfter(lectureDay);
    }
}