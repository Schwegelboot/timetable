package com.dhbw.timetable.web.requestDto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class GetLectureRequest {
    String lecturerID;
    String timeslotID;
}