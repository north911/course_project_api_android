package com.example.android.project.course_project.Utils;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {

    public static String parseSubGroupScheduleUri(Document doc, int subGroup) {
        Elements links = doc.select("a[href]");
        return links.get(2 + subGroup).attr("href");
    }

    public static Elements parseGroupSchedule(Document doc){
        return doc.select("td");
    }
}
