package com.dena.schedule;
import java.util.*;

class Section {
    private int crn;
    private String term;
    private String sectionNumber;
    private Course course;
    private Instructor instructor;
    private List<Slot> slots = new ArrayList<>();

    public Section(int crn, String term, String sectionNumber, Course course, Instructor instructor) {
        this.crn = crn;
        this.term = term;
        this.sectionNumber = sectionNumber;
        this.course = course;
        this.instructor = instructor;
        course.addSection(this);
        instructor.addSection(this);
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }
    public Course getCourse(){
        return course;
    }

    public List<Slot> getSlots() {
        return Collections.unmodifiableList(slots);
    }
}
