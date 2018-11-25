package com.example.android.project.course_project.Service;

import com.example.android.project.course_project.RequestSender.RequestSender;
import com.example.android.project.course_project.ResponseEntity.DaySchedule;
import com.example.android.project.course_project.ResponseEntity.Pair;
import com.example.android.project.course_project.ResponseEntity.WeekSchedule;
import com.example.android.project.course_project.Utils.HtmlParser;
import com.example.android.project.course_project.Utils.UriBuilder;
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
        return createWeeksSchedule(elements);
    }

    private List<WeekSchedule> createWeeksSchedule(Elements elements) {
        List<WeekSchedule> weekScheduleList = new ArrayList<>(4);
        setWeeksToList(weekScheduleList);
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i).attributes().get("colspan").equals("9")) {
                List<DaySchedule> dayScheduleList = createDays(i, elements);
                for (int j = 0; j < 4; j++) {
                    weekScheduleList.get(j).getDayScheduleList().add((dayScheduleList.get(j)));
                }
            }
        }
        elements.get(0).attributes().get("colspan");
        return weekScheduleList;
    }


    private List<DaySchedule> createDays(int startIndex, Elements elements) {
        List<DaySchedule> dayScheduleList = new ArrayList<>(4);
        setDaysToList(dayScheduleList);
        setDayToList(dayScheduleList, startIndex, elements);
        return dayScheduleList;
    }

    private void setDayToList(List<DaySchedule> dayScheduleList, int startIndex, Elements elements) {
        for (int i = 0; i < 4; i++) {
            dayScheduleList.get(i).setDayOfWeek(elements.get(startIndex).text());
        }
        int i = startIndex;
        while ( i + 13 < elements.size() && !elements.get(i + 1).attributes().get("colspan").equals("9")) {
            setPairLineToList(dayScheduleList, i, elements);
            i += 13;
        }
    }

    private void setPairLineToList(List<DaySchedule> dayScheduleList, int statIndex, Elements elements) {
        dayScheduleList.get(0).getPairList().add(createFirstWeekPair(statIndex, elements));
        dayScheduleList.get(1).getPairList().add(createSecondWeekPair(statIndex, elements));
        dayScheduleList.get(2).getPairList().add(createThirdWeekPair(statIndex, elements));
        dayScheduleList.get(3).getPairList().add(createFourthWeekPair(statIndex, elements));
    }

    private Pair createFirstWeekPair(int startDayIndex, Elements elements) {
        Pair pair = new Pair();
        pair.setTime(elements.get(startDayIndex + 1).text());
        pair.setName(elements.get(startDayIndex + 2).text());
        pair.setCabinet(elements.get(startDayIndex + 3).text());
        pair.setProfessor(elements.get(startDayIndex + 10).text());
        return pair;
    }

    private Pair createSecondWeekPair(int startDayIndex, Elements elements) {
        Pair pair = new Pair();
        pair.setTime(elements.get(startDayIndex + 1).text());
        pair.setName(elements.get(startDayIndex + 4).text());
        pair.setCabinet(elements.get(startDayIndex + 5).text());
        pair.setProfessor(elements.get(startDayIndex + 11).text());
        return pair;
    }

    private Pair createThirdWeekPair(int startDayIndex, Elements elements) {
        Pair pair = new Pair();
        pair.setTime(elements.get(startDayIndex + 1).text());
        pair.setName(elements.get(startDayIndex + 6).text());
        pair.setCabinet(elements.get(startDayIndex + 7).text());
        pair.setProfessor(elements.get(startDayIndex + 12).text());
        return pair;
    }

    private Pair createFourthWeekPair(int startDayIndex, Elements elements) {
        Pair pair = new Pair();
        pair.setTime(elements.get(startDayIndex + 1).text());
        pair.setName(elements.get(startDayIndex + 8).text());
        pair.setCabinet(elements.get(startDayIndex + 9).text());
        pair.setProfessor(elements.get(startDayIndex + 13).text());
        return pair;
    }

    private void setWeeksToList(List<WeekSchedule> weekScheduleList) {
        for (int i = 0; i < 4; i++) {
            weekScheduleList.add(new WeekSchedule(i + 1));
        }
    }

    private void setDaysToList(List<DaySchedule> dayScheduleList) {
        for (int i = 0; i < 4; i++) {
            dayScheduleList.add(new DaySchedule());
        }
    }
}
