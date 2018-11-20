package com.example.android.project.course_project.ResponseEntity;

import java.util.List;

public class WeekSchedule {
    private int numberOfWeek;
    private List<DaySchedule> dayScheduleList;

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public List<DaySchedule> getDayScheduleList() {
        return dayScheduleList;
    }

    public void setDayScheduleList(List<DaySchedule> dayScheduleList) {
        this.dayScheduleList = dayScheduleList;
    }
}
