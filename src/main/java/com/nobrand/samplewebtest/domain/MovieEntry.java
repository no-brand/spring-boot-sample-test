package com.nobrand.samplewebtest.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MovieEntry {

    private String title;
    private String summary;
    private Date created;

    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public MovieEntry(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.summary = summary;
        this.created = format.parse(date);
    }

    MovieEntry() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(String date) throws ParseException {
        this.created = format.parse(date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Movie(");
        sb.append("title=").append(title);
        sb.append(", summary=").append(summary);
        sb.append(", created=").append(created);
        sb.append(")");
        return sb.toString();
    }
}
