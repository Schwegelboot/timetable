package com.dhbw.timetable.web.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhbw.timetable.business.lecture.DeleteLecture;
import com.dhbw.timetable.web.requestDto.DeleteLectureRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class DeleteLectureController {
    @Autowired
    DeleteLecture deleteLecture;

    @DeleteMapping(path = "lecture/delete")
    public void createLecture(@RequestParam String lectureID){
        DeleteLectureRequest request = DeleteLectureRequest.builder()
                .lectureId(lectureID)
                .build();
        deleteLecture.perform(request);
    }
}