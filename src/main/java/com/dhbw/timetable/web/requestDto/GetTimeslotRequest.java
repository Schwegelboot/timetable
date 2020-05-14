package com.dhbw.timetable.web.requestDto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class GetTimeslotRequest {
    String course;
    String timeslotID;
}