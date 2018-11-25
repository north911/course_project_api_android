package com.example.android.project.course_project.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private String dayOfWeek;
    private List<Pair> pairList;

    public DaySchedule(){
        pairList = new ArrayList<>();
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Pair> getPairList() {
        return pairList;
    }

    public void setPairList(List<Pair> pairList) {
        this.pairList = pairList;
    }
}
