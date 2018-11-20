package com.example.android.project.course_project.Utils;

public class UriBuilder {

    private final static String SCHEDULE_SEARCH_URI = "http://bsac.by:8080/timetable?searchString=";
    private final static String SCHEDULE_URI= "http://bsac.by:8080/";


    public static String buildGroupSearchUri(String group) {
        return SCHEDULE_SEARCH_URI + group;
    }

    public static String buildGroupScheduleUri(String uri){
        return SCHEDULE_URI + uri;
    }
}
