package com.dhbw.timetable.web.requestDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTimeslotRequest {
    CreateTimeslotMessage message;
}
