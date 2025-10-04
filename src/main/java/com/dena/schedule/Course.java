package com.dena.schedule;
import java.util.*;

class Course {
    private String courseCode;
    private String title;
    private Department department;
    private List<Section> sections = new ArrayList<>();

    public Course(String courseCode, String title, Department department) {
        this.courseCode = courseCode;
        this.title = title;
        this.department = department;
        department.addCourse(this);
    }

    public void addSection(Section section) {
        sections.add(section);
    }
    public String getTitle() {
        return title;
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }
}