package com.dena.schedule;
import java.util.*;

class Department {
    private String deptCode;
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Department(String deptCode, String name) {
        this.deptCode = deptCode;
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}