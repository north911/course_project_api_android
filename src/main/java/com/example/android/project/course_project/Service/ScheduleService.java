package com.example.android.project.course_project.Service;

import com.example.android.project.course_project.RequestSender.RequestSender;
import com.example.android.project.course_project.ResponseEntity.DaySchedule;
import com.example.android.project.course_project.ResponseEntity.Pair;
import com.example.android.project.course_project.ResponseEntity.WeekSchedule;
import com.example.android.project.course_project.Utils.HtmlParser;
import com.example.android.project.course_project.Utils.UriBuilder;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    public List<WeekSchedule> getGroupSchedule(String group) {
        String groupUri = UriBuilder.buildGroupSearchUri(group);
        String uriSchedule = HtmlParser.parseSubGroupScheduleUri(RequestSender.getResponseBodyOfRequest(groupUri));
        uriSchedule = UriBuilder.buildGroupScheduleUri(uriSchedule);
        Elements elements = HtmlParser.parseGroupSchedule(RequestSender.getResponseBodyOfRequest(uriSchedule));
        return createSchedule(elements);
    }

    private List<WeekSchedule> createSchedule(Elements elements) {
        List<WeekSchedule> weekScheduleList = new ArrayList<>();
        WeekSchedule weekSchedule1 = new WeekSchedule();
        WeekSchedule weekSchedule2 = new WeekSchedule();
        WeekSchedule weekSchedule3 = new WeekSchedule();
        WeekSchedule weekSchedule4 = new WeekSchedule();

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).attributes().get("colspan").equals("9")) {

            }
        }
        elements.get(0).attributes().get("colspan");

        return null;
    }

    private Pair createPair(int startIndex, String time, Elements elements) {
        Pair pair = new Pair();
        pair.setTime(time);
        pair.setName(elements.get(startIndex).text());
        pair.setProfessor(elements.get(startIndex + 7).text());
        return pair;
    }

    private DaySchedule createDay(int startIndex, String dayOfWeek, Elements elements) {
        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setDayOfWeek(dayOfWeek);
        return daySchedule;
    }
}
