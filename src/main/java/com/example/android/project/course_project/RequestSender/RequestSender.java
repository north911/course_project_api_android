package com.example.android.project.course_project.RequestSender;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RequestSender {

    public static Document getResponseBodyOfRequest(String uri) {
        Document doc = null;
        try {
            doc = Jsoup.connect(uri).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
