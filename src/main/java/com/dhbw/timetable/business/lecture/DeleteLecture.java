package com.dhbw.timetable.business.lecture;

import com.dhbw.timetable.web.requestDto.DeleteLectureRequest;

public interface DeleteLecture {
   void perform(DeleteLectureRequest request);
}
