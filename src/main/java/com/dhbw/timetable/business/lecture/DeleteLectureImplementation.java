package com.dhbw.timetable.business.lecture;

import org.springframework.stereotype.Service;

import com.dhbw.timetable.backend.SpringReactiveMongoLectureGateway;
import com.dhbw.timetable.web.requestDto.DeleteLectureRequest;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class DeleteLectureImplementation implements DeleteLecture {

    @NonNull
    SpringReactiveMongoLectureGateway lectureGateway;

    @Override public void perform(DeleteLectureRequest request) {
        lectureGateway.deleteById(request.getLectureId()).subscribe();
    }
}