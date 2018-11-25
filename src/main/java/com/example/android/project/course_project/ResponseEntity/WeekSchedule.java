package com.example.android.project.course_project.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class WeekSchedule {
    private int numberOfWeek;
    private List<DaySchedule> dayScheduleList;

    public WeekSchedule (int numberOfWeek){
        this.numberOfWeek = numberOfWeek;
        dayScheduleList = new ArrayList<>(6);
//        add6daysToWeek(dayScheduleList);
    }

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

    private void add6daysToWeek(List<DaySchedule> dayScheduleList) {
        for (int i = 0; i < 6; i++) {
            dayScheduleList.add(new DaySchedule());
        }
    }
}

