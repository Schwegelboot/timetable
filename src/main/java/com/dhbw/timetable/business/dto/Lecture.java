package com.dhbw.timetable.business.dto;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Document
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lecture {
    @Id
    String id;
    String name;
    String lecturerID;
    String timeslotID;
    String course;
    String location;
    DateTime lectureDay;
    DateTime startTime;
    DateTime endTime;
    int duration;
}