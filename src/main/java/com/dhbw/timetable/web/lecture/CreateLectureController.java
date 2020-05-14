package com.dhbw.timetable.web.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.timetable.business.lecture.CreateLecture;
import com.dhbw.timetable.business.dto.Lecture;
import com.dhbw.timetable.web.requestDto.CreateLectureMessage;
import com.dhbw.timetable.web.requestDto.CreateLectureRequest;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class CreateLectureController {
    @Autowired
    CreateLecture createLecture;

    @PostMapping(path = "lecture/create")
    public Mono<Lecture> createLecture(@RequestBody CreateLectureMessage message){
        CreateLectureRequest request = CreateLectureRequest.builder()
                .message(message)
                .build();
        return createLecture.perform(request);
    }
}