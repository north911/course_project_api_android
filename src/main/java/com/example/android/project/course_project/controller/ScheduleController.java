package com.example.android.project.course_project.controller;

import com.example.android.project.course_project.ResponseEntity.WeekSchedule;
import com.example.android.project.course_project.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/getSchedule", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<WeekSchedule> getScheduleHtml(@RequestParam(name = "groupName") String groupName, @RequestParam(name = "subGroup") int subGroup) throws UnsupportedEncodingException {
        return scheduleService.getGroupSchedule(URLEncoder.encode(groupName, "UTF-8"), subGroup);
    }
}
