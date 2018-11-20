package com.example.android.project.course_project.Utils;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {

    public static String parseSubGroupScheduleUri(Document doc) {
        Elements links = doc.select("a[href]");
        return links.get(3).attr("href");
    }

    public static Elements parseGroupSchedule(Document doc){
        Elements ps = doc.select("td");
        return ps;
    }
}
