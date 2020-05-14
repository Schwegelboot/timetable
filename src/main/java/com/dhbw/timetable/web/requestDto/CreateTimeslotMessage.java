package com.dhbw.timetable.web.requestDto;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@RequiredArgsConstructor
@Data
@Value
public class CreateTimeslotMessage {
    String name;
    String course;
    boolean isActive;
    DateTime startTime;
    DateTime endTime;
}